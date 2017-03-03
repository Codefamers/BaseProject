package com.qhn.bhne.baseproject.mvp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.di.scope.ContextLife;
import com.qhn.bhne.baseproject.listener.ClickAdapterItemListener;
import com.qhn.bhne.baseproject.mvp.entity.SongMenuType;
import com.qhn.bhne.baseproject.mvp.ui.adapter.base.BaseRecyclerViewAdapter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by qhn
 * on 2017/2/28 0028.
 */

public class SongMenuTypeAdapter extends BaseRecyclerViewAdapter<SongMenuType,SongMenuType.ChildBean> {
    private static final int TYPE_ITEM = 0;//item类型
    private static final int TYPE_TITLE = 1;//title类型
    private HashMap<Integer, String> titleDataMap;//标题数据
    private List<SongMenuType> contentData;//内容数据
    private Map<Integer, SongMenuType.ChildBean> posItemMap;//记录item与position对应关系


    private int index;
    @ContextLife
    @Inject
    Context context;

    @Inject
    public SongMenuTypeAdapter() {
        super(null);
    }

    @Override
    public void setList(List items) {
        super.setList(items);
        initTitleData();
    }

    private void initTitleData() {
        posItemMap = new HashMap<>();
        titleDataMap = new HashMap<>();
        contentData = getList();
        Set<String> titleSet = new HashSet<>();
        index = 0;
        int titleNum = 0;
        for (int i = 0; i < contentData.size(); i++) {
            SongMenuType songMenuType = contentData.get(i);
            String convert = songMenuType.getCategoryname();
            if (titleSet.add(convert)) {
                titleNum = index;
                titleDataMap.put(index, convert);

            }
            for (int j = 0; j < songMenuType.getSongMenuTypeChild().size(); j++) {
                posItemMap.put(j + titleNum, songMenuType.getSongMenuTypeChild().get(j));
                index++;
            }
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            return new ContentViewHolder(LayoutInflater.from(
                    context).inflate(R.layout.item_song_menu_type, parent,
                    false));
        }
        if (viewType == TYPE_TITLE) {
            return new TitleViewHolder(LayoutInflater.from(
                    context).inflate(R.layout.item_song_menu_header, parent,
                    false));

        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ContentViewHolder) {

            ((ContentViewHolder) holder).btnSongMenuType.setText(posItemMap.get(position).getCategoryname());
        }
        if (holder instanceof TitleViewHolder) {
            ((TitleViewHolder) holder).txtSongMenuTitle.setText(titleDataMap.get(position));
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return isFooter(position) ? gridManager.getSpanCount() : 1;
                }
            });
        }
    }

    private boolean isFooter(int position) {
        int type = getItemViewType(position);
        if (type == TYPE_TITLE) {
            return true;//只占一行中的一列，
        }
        return false;
    }

    @Override
    public int getItemViewType(int position) {
        if (titleDataMap.containsKey(position))
            return TYPE_TITLE;
        else
            return TYPE_ITEM;
    }


    @Override
    public int getItemCount() {

        return index;
    }

    class ContentViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.btn_song_menu_type)
        Button btnSongMenuType;

        public ContentViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemListener.onClick(posItemMap.get(getAdapterPosition()));
                }
            });
        }
    }

    class TitleViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_song_menu_title)
        TextView txtSongMenuTitle;


        public TitleViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }
    }
}
