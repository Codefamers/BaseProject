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
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.qhn.bhne.baseproject.R;
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



import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/10/17 0017.
 */

public class ContactsPersonAdapter extends RecyclerView.Adapter {
    private static final int TYPE_ITEM = 0;//item类型
    private static final int TYPE_TITLE = 1;//title类型
    private final HashMap<Integer, String> titleDataMap;//标题数据
    private List<ChannelList.ChannelBean> contentData;//内容数据
    private Map<Integer, ChannelList.ChannelBean> posItemMap;//记录item与position对应关系
    private Context context;//上下文环境
    private int titleNum = 0;

    public ContactsPersonAdapter(Context context ,List<ChannelList.ChannelBean> contentData) {
        this.context=context;
        this.contentData = contentData;
        posItemMap = new HashMap<>();
        titleDataMap = new HashMap<Integer, String>();
        initTitleData();//将标题中的数据位置与recyclerView中的位置对齐
    }

    private void initTitleData() {
        Set<String> titleSet = new HashSet<>();
        for (int i = 0; i < contentData.size(); i++) {
            String convert = contentData.get(i).getParentname();
            if (titleSet.add(convert)) {
                titleDataMap.put(i + titleNum, convert);
                titleNum++;
            }
            posItemMap.put(i+ titleNum,contentData.get(i));
        }
        KLog.d(posItemMap.size());
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

            MyUtils.loadImageFormNet(posItemMap.get(position).getLarge_pic_url(), ((ContentViewHolder) holder)
                    .imgPic, (Activity) context);
            String title=String.format("#%s#",posItemMap.get(position).getSonglist_name());
            SpannableStringBuilder ssb=new SpannableStringBuilder(title);
            ssb.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.colorPrimary)),
                    0,title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            ssb.setSpan(new AbsoluteSizeSpan((int) DimenUtil.sp2px(16)),0,title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            ssb.setSpan(new StyleSpan(Typeface.ITALIC),0,title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            ssb.append(posItemMap.get(position).getDetails());
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
        return contentData.size() + titleDataMap.size();
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