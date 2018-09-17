package net.qiujuer.italker.common.widget.recycler;

/**
 * Created by shiqiang on 2018/9/15.
 */

public interface AdapterCallback<Data> {
    void updata(Data data, RecyclerAdapter.ViewHolder<Data> holder);
}
