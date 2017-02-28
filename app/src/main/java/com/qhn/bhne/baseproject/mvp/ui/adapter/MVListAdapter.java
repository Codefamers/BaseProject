package com.qhn.bhne.baseproject.mvp.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.qhn.bhne.baseproject.R;
import com.qhn.bhne.baseproject.di.scope.ContextLife;
import com.qhn.bhne.baseproject.mvp.entity.MVList;
import com.qhn.bhne.baseproject.utils.MyUtils;
import com.qhn.bhne.baseproject.wight.ShapedImageView;
import com.socks.library.KLog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by qhn
 * on 2016/11/8 0008.
 */
public class MVListAdapter extends RecyclerView.Adapter {
    private static final int TYPE_ITEM = 0;//item类型
    private static final int TYPE_TITLE = 1;//title类型


    private HashMap<Integer, String> titleDataMap;//标题数据
    private HashMap<String, List<MVList.MVBean>> contentData;//内容数据
    private Map<Integer, MVList.MVBean> posItemMap;//记录item与position对应关系
    @ContextLife("Fragment")
    @Inject
    Context context;
    private int titleNum = 0;
    private int itemPos = 0;

    public MVListAdapter(Context context, HashMap<String, List<MVList.MVBean>> dataMap) {
        this.context = context;

        contentData = dataMap;
        posItemMap = new HashMap<>();
        titleDataMap = new HashMap<Integer, String>();
        if (dataMap != null) {
            initTitleData();//将标题中的数据位置与recyclerView中的位置对齐

        }
    }

    private void initTitleData() {
        Set<String> titleSet = contentData.keySet();
        Object[] titleArray = titleSet.toArray();
        for (int i = 0; i < titleSet.size(); i++) {
            titleDataMap.put(itemPos + titleNum, (String) titleArray[i]);
            ++titleNum;
            KLog.d(contentData.get(titleArray[i]).size());
            for (int a = 0; a < contentData.get(titleArray[i]).size(); a++) {
                posItemMap.put(titleNum + itemPos, contentData.get(titleArray[i]).get(a));
                itemPos++;
            }
        }
        KLog.d(posItemMap.size());
        KLog.d(titleDataMap.size());

    }

    public void addMore(HashMap<String, List<MVList.MVBean>> dataMap) {
        int startPosition = contentData==null?0:contentData.size();
        if (dataMap!=null) {
            contentData.putAll(dataMap);
        }
        notifyItemRangeInserted(startPosition, contentData.size());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            return new ContentViewHolder(LayoutInflater.from(
                    context).inflate(R.layout.item_mv_list, parent,
                    false));
        }
        if (viewType == TYPE_TITLE) {
            return new TitleViewHolder(LayoutInflater.from(
                    context).inflate(R.layout.item_mv_list_header, parent,
                    false));

        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ContentViewHolder) {
            if (posItemMap.get(position) != null) {
                ContentViewHolder contentHold = (ContentViewHolder) holder;
                MVList.MVBean mvBean = posItemMap.get(position);
                MyUtils.loadImageFormNet(mvBean.getPicUrl(), contentHold
                        .imgPic, (Activity) context);
                contentHold.txtMusicAlbumName.setText(mvBean.getVideoName());
                contentHold.txtMusicVideoAuthor.setText(mvBean.getSingerName());
                if (mvBean.getPickCount() != 0) {
                    contentHold.txtListen.setText(String.valueOf(MyUtils.dealBigNum(mvBean.getPickCount())));
                    contentHold.txtListen.setVisibility(View.VISIBLE);
                }


            }

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
        if (contentData != null) {
            return posItemMap.size() + titleDataMap.size();
        }
        return 0;
    }

    class ContentViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_pic)
        ShapedImageView imgPic;
        @BindView(R.id.txt_listen)
        TextView txtListen;
        @BindView(R.id.txt_music_album_name)
        TextView txtMusicAlbumName;
        @BindView(R.id.txt_music_video_author)
        TextView txtMusicVideoAuthor;

        public ContentViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    class TitleViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_song_menu_title)
        TextView txtSongMenuTitle;
        @BindView(R.id.txt_more_mv)
        TextView txtMoreMv;

        public TitleViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            txtMoreMv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "更多视频", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
