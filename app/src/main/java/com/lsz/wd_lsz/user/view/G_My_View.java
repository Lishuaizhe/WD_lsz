package com.lsz.wd_lsz.user.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lsz.wd_lsz.R;

public class G_My_View extends LinearLayout {

    private EditText editText;
    private TextView jia;
    private TextView jian;
    private int Sum=1;

    public G_My_View(Context context) {
        this(context,null);
    }

    public G_My_View(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public G_My_View(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View view =LayoutInflater.from(context).inflate(R.layout.zidingyi,this,true);
        jian = view.findViewById(R.id.minus);
        editText = view.findViewById(R.id.et_num);
        jia = view.findViewById(R.id.add);

        jia.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Sum++;
                editText.setText(Sum+"");
                if (ig_my_view!=null){
                    ig_my_view.IG_My_View(Sum);
                }
            }
        });

        jian.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Sum--;
                if (Sum==0){
                    Sum=1;
                    Toast.makeText(getContext(),"还买吗？",Toast.LENGTH_SHORT).show();
                }
                editText.setText(Sum+"");
                if (ig_my_view!=null){
                    ig_my_view.IG_My_View(Sum);
                }
            }
        });
    }

    private IG_My_View ig_my_view;

    public void setIg_my_view(IG_My_View ig_my_view) {
        this.ig_my_view = ig_my_view;
    }

    public interface IG_My_View{
        void IG_My_View(int Sum);
    }


}
