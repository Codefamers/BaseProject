package com.qhn.bhne.baseproject.mvp.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.di.scope.ContextLife;
import com.qhn.bhne.baseproject.mvp.entity.BroadcastDetail;
import com.qhn.bhne.baseproject.mvp.entity.ChannelList;
import com.qhn.bhne.baseproject.utils.DimenUtil;
import com.qhn.bhne.baseproject.utils.MyUtils;
import com.qhn.bhne.baseproject.wight.ShapedImageView;
import com.socks.library.KLog;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/10/17 0017.
 */

public class ContactsPersonAdapter extends RecyclerView.Adapter {
    private static final int TYPE_ITEM = 0;//item类型
    private static final int TYPE_TITLE = 1;//title类型
    private final HashMap<Integer, String> titleDataMap;//标题数据
    private List<List<BroadcastDetail.DataBean>> contentData;//内容数据
    private Map<Integer, BroadcastDetail.DataBean> posItemMap;//记录item与position对应关系

    Context context;//上下文环境
    private int index;


    public ContactsPersonAdapter(Context context,List<List<BroadcastDetail.DataBean>> contentData) {
        this.context=context;
        this.contentData = contentData;
        posItemMap = new HashMap<>();
        titleDataMap = new HashMap<>();
        initTitleData();//将标题中的数据位置与recyclerView中的位置对齐
    }

    private void initTitleData() {
        Set<String> titleSet = new HashSet<>();
        index=0;
        int titleNum=0;
        for (int i = 0; i < contentData.size(); i++) {
            List<BroadcastDetail.DataBean> dataBeanList=contentData.get(i);
            for (int j = 0; j < dataBeanList.size(); j++) {
                String convert = dataBeanList.get(j).getClassname();

                if (titleSet.add(convert)) {
                    titleNum=index;
                    titleDataMap.put(index, convert);

                }
                posItemMap.put(j + titleNum, dataBeanList.get(j));
                index++;
            }



        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            return new ContentViewHolder(LayoutInflater.from(
                    context).inflate(R.layout.item_song_menu, parent,
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
            //((ContentViewHolder) holder).txtMusicAlbumName.setText(posItemMap.get(position).getDetails());
            //((ContentViewHolder) holder).txtAuthor.setText(posItemMap.get(position).getSonglist_name());
            KLog.d("posItemMap"+posItemMap.get(position).getImgurl().replace("{size}","400"));
            MyUtils.loadImageFormNet(posItemMap.get(position).getImgurl().replace("{size}","400"), ((ContentViewHolder) holder)
                    .imgPic,  context);
            String title = String.format("#%s#", posItemMap.get(position).getClassname());
            SpannableStringBuilder ssb = new SpannableStringBuilder(title);
            ssb.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.colorPrimary)),
                    0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            ssb.setSpan(new AbsoluteSizeSpan((int) DimenUtil.sp2px(16)), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            ssb.setSpan(new StyleSpan(Typeface.ITALIC), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            ssb.append(posItemMap.get(position).getDescription());
            ((ContentViewHolder) holder).txtMusicAlbumName.setText(ssb);
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

        return index ;
    }

    class ContentViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_pic)
        ShapedImageView imgPic;
        /* @BindView(R.id.txt_author)
         TextView txtAuthor;*/
        @BindView(R.id.txt_listen)
        TextView txtListen;
        @BindView(R.id.txt_music_album_name)
        TextView txtMusicAlbumName;

        public ContentViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
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