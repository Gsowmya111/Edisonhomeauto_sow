package automation.edisonbro.com.edison.cooldraganddrop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import automation.edisonbro.com.edison.CombinedFragment;
import automation.edisonbro.com.edison.R;

import static automation.edisonbro.com.edison.CombinedFragment.mItemAdapter;
import static automation.edisonbro.com.edison.CombinedFragment.z;

public class ItemAdapter extends ArrayAdapter<Item> implements SpanVariableGridView.CalculateChildrenPosition {
	private ImageView selectedView = null;
	Integer []old = new Integer[1];
	public Integer[] images11={ R.drawable.ac01,R.mipmap.dimmer_grid,R.drawable.ac01,R.drawable.ac01,R.drawable.ac01,R.drawable.ac01,R.drawable.ac01,R.drawable.ac01,R.drawable.ac01};
	private int x;
	Item[] y = new Item[1];

	private final class ItemViewHolder {

		public TextView itemTitle;
		public TextView itemDescription;
		public ImageView itemIcon;

	}

	private Context mContext;
	private LayoutInflater mLayoutInflater = null;

	private View.OnClickListener onRemoveItemListener = new View.OnClickListener() {

		@Override
		public void onClick(View view) {

			Integer position = (Integer) view.getTag();
			removeItem(getItem(position));

		}
	};

	public void insertItem(Item item, int where) {

		if (where < 0 || where > (getCount() - 1)) {

			return;
		}

		insert(item, where);
	}

	public boolean removeItem(Item item) {

		remove(item);

		return true;
	}

	public ItemAdapter(Context context, List<Item> plugins) {

		super(context, R.layout.gridview_item, plugins);

		mContext = context;
		mLayoutInflater = LayoutInflater.from(context);
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {

		final ItemViewHolder itemViewHolder;

		if (convertView == null) {
			convertView = mLayoutInflater.inflate(R.layout.gridview_item, parent, false);

			itemViewHolder = new ItemViewHolder();
			itemViewHolder.itemIcon = (ImageView) convertView.findViewById(R.id.imageViewIcon);
			convertView.setTag(itemViewHolder);



		} else {

			itemViewHolder = (ItemViewHolder) convertView.getTag();
		}
		final Item item = getItem(position);

		SpanVariableGridView.LayoutParams lp = new SpanVariableGridView.LayoutParams(convertView.getLayoutParams());
		//lp.span = item.getSpans();
		convertView.setLayoutParams(lp);
		itemViewHolder.itemIcon.setImageResource(item.getIcon());






		itemViewHolder.itemIcon.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

					/*if(old[0]!=null)
					{
                         selectedView.setImageResource(old[0]);
						//Toast.makeText(Second.this,""+old[0],Toast.LENGTH_LONG).show();
						//notifyDataSetChanged();
					}*/


				//	mItemAdapter = new ItemAdapter(mContext.getApplicationContext(), z);


				//	((MyAdapter)gv.getAdapter()).notifyDataSetChanged();

				if(old[0]!=null) {
					itemViewHolder.itemIcon.setImageResource(old[0]);
				}


				if(position==0)
				{
					//  old[0]=getItemViewType(0);
					//itemViewHolder.itemIcon.setImageResource(images11[0]);

					old[0]=images11[0];
					//CombinedFragment.mCoolDragAndDropGridView.getAdapter().notifyDataSetChanged();


					//	old[0]=images[0];
					//selectedView=itemViewHolder.itemIcon;




				}else if(position==1)
				{
					//itemViewHolder.itemIcon.setImageResource(images11[1]);


					old[0]=images11[1];
					//CombinedFragment.mCoolDragAndDropGridView.getAdapter().notifyDataSetChanged();

					//CombinedFragment.mCoolDragAndDropGridView.getAdapter().notifyDataSetChanged();
					//old[0]=images[1];
					//	selectedView=itemViewHolder.itemIcon;

				}


			}
		});








		return convertView;

	}

	@Override
	public void onCalculatePosition(View view, int position, int row, int column) {

	}
}
