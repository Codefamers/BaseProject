package com.qhn.bhne.xhmusic.mvp.ui.activities;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.qhn.bhne.xhmusic.R;
import com.qhn.bhne.xhmusic.mvp.entity.HistorySearch;
import com.qhn.bhne.xhmusic.mvp.ui.activities.base.BaseActivity;
import com.qhn.bhne.xhmusic.mvp.ui.fragment.SearchRecommendFragment;
import com.qhn.bhne.xhmusic.mvp.ui.fragment.SearchResultFragment;

import butterknife.BindView;

public class SearchActivity extends BaseActivity implements SearchRecommendFragment.SrfListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    SearchRecommendFragment searchRecommendFragment;
    SearchResultFragment searchResultFragment;
    private Boolean isResultFragment = false;
    private static final String RECOMMEND_FRAGMENT = "searchRecommendFragment";
    private FragmentManager fragmentManager;
    private SearchView searchView;
    private String query;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    protected void initViews() {
        searchRecommendFragment = new SearchRecommendFragment();

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fg_empty, searchRecommendFragment);

        transaction.commit();

    }


    @Override
    protected void initInjector() {
        getmActivityComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            //获取搜索关键字字符串
            String query = intent.getStringExtra(SearchManager.QUERY);
            // searchRecommendFragment.addHistoryTag(query);
            searchRecommendFragment.getPresenter().saveHistoryRecord(new HistorySearch(null, query));
            searchRecommendFragment.getPresenter().doSearch(query);
        }
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView = (SearchView) MenuItemCompat.getActionView(item);
        SearchableInfo info = searchManager.getSearchableInfo(getComponentName());
        searchView.setSearchableInfo(info);
        searchView.onActionViewExpanded();
        searchView.setIconifiedByDefault(false);
        searchView.clearFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(SearchActivity.this, "提交1", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText) && isResultFragment) {
                    returnRecommendFrg();
                }
                return false;
            }
        });

        return true;
    }

    private void returnRecommendFrg() {

        isResultFragment=false;
        getSupportFragmentManager().popBackStack();

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if (item.getItemId() == R.id.action_search) {
            Toast.makeText(this, "搜索", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    @Override
    public void returnResultFrg(String query) {
        searchResultFragment = new SearchResultFragment();

        setQuery(query);
        searchView.setQuery(query, false);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fg_empty, searchResultFragment);
        isResultFragment = true;
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
