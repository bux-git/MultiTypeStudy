# MultiTypeStudy   
### 学习资料来源
[Android 复杂的列表视图新写法 MultiType](http://gank.io/post/5823bcf6421aa90e799ec2ad#multitype-的特性)      

![image](https://github.com/bux-git/MultiTypeStudy/blob/master/multy_type01.gif?raw=true)        

__HomeActivity布局思路记录__      
    观察得出：
第一项 第二项 单独布局，   
后面其他所有项包含有共同的最外层布局，同时考虑到底部按钮有单项刷新功能因此放弃使用数据扁平化处理，   
将其中每一个资料作为RecyclerView的一个单独子Item处理      
每一个单独资料项分为最外层区域和中间内容区域  
最外层区域可以共用代码因此建立数据模型：    

    public class FrameBean {
    //最外层各项显示数据配置
        private int leftImgResId;
        private int leftTitleResId;
        private int rightTitle;
        private int rightImgReId;
        private int replaceResId;
        //内容类型
        private DataType type;
        //内容容器
        private Content mContent;
    ｝
    //内容容器
    public class Content<T> {
        private List<T> mList;
    
        public Content(List<T> list) {
            mList = list;
        }
    
        public List<T> getList() {
            return mList;
        }
    
        public void setList(List<T> list) {
            mList = list;
        }
    }



    public abstract class FrameViewBinder<T> extends ItemViewBinder<FrameBean, FrameViewBinder.FrameViewHolder> {

    private LayoutInflater mInflater;
    public Context mContext;
    /**
     * 创建子项布局
     *
     * @param inflater
     * @param parent
     * @param dataSize
     * @return
     */
    public abstract View onSubCreateView(LayoutInflater inflater, ViewGroup parent, int dataSize,int index);

    /**
     * 绑定数据
     *
     * @param itemView 单项View
     * @param subList  数据集合
     * @param index    当前数据下标
     */
    public abstract void onSubViewBind(View itemView, List<T> subList, int index);

    @NonNull
    @Override
    protected FrameViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
      
    }

    @Override
    protected void onBindViewHolder(@NonNull FrameViewBinder.FrameViewHolder holder, @NonNull FrameBean item) {
        ........
        if(item.getContent().getList()==null)return;
        LinearLayout container = holder.lltContainer;
        int containerChildSize = container.getChildCount();
        int dataSize = item.getContent().getList().size();
        //容器有子项 且 数量与数据相同 则直接重新赋值  否则清除容器所有子View 重新添加
        if (containerChildSize == 0 || containerChildSize != dataSize) {
            container.removeAllViews();
            for(int i=0;i<dataSize;i++) {
                View childView = onSubCreateView(mInflater, container, dataSize,i);
                if(childView!=null) {
                    container.addView(childView);
                }
            }
        }
        //绑定数据
        for (int i = 0; i < dataSize; i++) {
            onSubViewBind(container.getChildAt(i), item.getContent().getList(), i);
        }
    }

    class FrameViewHolder extends RecyclerView.ViewHolder {
        //内容容器
        LinearLayout lltContainer;
        public FrameViewHolder(View itemView) {
            super(itemView);
 
        }

        private <T extends View> T find(int resId) {
            return (T) itemView.findViewById(resId);
        }
    }
}

其中内容项将显示的每一行做为一个子项 添加到子项容器lltContainer 中，所以每一个子项内容都需要继承FrameViewBinder 来返回每一行的视图和绑定每一行的数据