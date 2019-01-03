package tzl.com.framework.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import tzl.com.framework.helper.DensityHelper;

/**
 * author: tangzenglei
 * created on: 2017/4/21 下午3:43
 * description: 自定义dialog
 */
public class CustomCenterDialog extends Dialog {


    private Context context;
    private int     height, width;
    private boolean isWidthFixed;
    private boolean isHeigthFixed;
    private boolean cancelTouchOut;
    private View    view;

    private CustomCenterDialog(Builder builder) {
        super(builder.context);
        context = builder.context;
        height = builder.height;
        width = builder.width;
        isWidthFixed = builder.isWidthFixed;
        isHeigthFixed = builder.isHeigthFixed;
        cancelTouchOut = builder.cancelTouchOut;
        view = builder.view;
    }


    public View findViewById(int resId) {
        return view.findViewById(resId);

    }


    public void setText(int resId,String msg) {
        TextView textView = (TextView) view.findViewById(resId);
        textView.setText(msg);
    }







    private CustomCenterDialog(Builder builder, int resStyle) {
        super(builder.context, resStyle);
        context = builder.context;
        height = builder.height;
        width = builder.width;
        isWidthFixed = builder.isWidthFixed;
        isHeigthFixed = builder.isHeigthFixed;
        cancelTouchOut = builder.cancelTouchOut;
        view = builder.view;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(view);
        setCanceledOnTouchOutside(cancelTouchOut);
        Window win = getWindow();
        WindowManager.LayoutParams lp = win.getAttributes();
        lp.gravity = Gravity.CENTER;
        if (isWidthFixed) {
            lp.width = width;
        }
        if (isHeigthFixed) {
            lp.height = height;
        }
        win.setAttributes(lp);
    }

    public static final class Builder {

        private Context context;
        private int     height;
        private int     width;
        private boolean isWidthFixed;
        private boolean isHeigthFixed;
        private boolean cancelTouchOut;
        private View    view;
        private int resStyle = -1;


        public Builder(Context context) {
            this.context = context;
        }

        public Builder view(int resView) {
            view = LayoutInflater.from(context).inflate(resView, null);
            return this;
        }
        public Builder view(View resView) {
            view = resView;
            return this;
        }

        public Builder heightpx(int val) {
            height = val;
            return this;
        }

        public Builder widthpx(int val) {
            width = val;
            return this;
        }


        public Builder widthFixed(boolean isWidthFixed) {
            this.isWidthFixed = isWidthFixed;
            return this;
        }



        public Builder heigthFixed(boolean isHeigthFixed) {
            this.isHeigthFixed = isHeigthFixed;
            return this;
        }

        public Builder heightdp(float val) {
            height = DensityHelper.dp2px(context,(int) val);
            return this;
        }

        public Builder widthdp(int val) {
            width = DensityHelper.dp2px(context,(int) val);
            return this;
        }

        public Builder heightDimenRes(int dimenRes) {
            height = context.getResources().getDimensionPixelOffset(dimenRes);
            return this;
        }

        public Builder widthDimenRes(int dimenRes) {
            width = context.getResources().getDimensionPixelOffset(dimenRes);
            return this;
        }

        public Builder style(int resStyle) {
            this.resStyle = resStyle;
            return this;
        }

        public Builder cancelTouchOut(boolean val) {
            cancelTouchOut = val;
            return this;
        }

        public Builder addViewOnclick(int viewRes, View.OnClickListener listener) {
            view.findViewById(viewRes).setOnClickListener(listener);
            return this;
        }


        public CustomCenterDialog build() {
            if (resStyle != -1) {
                return new CustomCenterDialog(this, resStyle);
            } else {
                return new CustomCenterDialog(this);
            }
        }
    }
}
