package com.zcsp.zjmonitor.app.manager.toolbar;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zcsp.zjmonitor.R;

/**
 * author: gaogq
 * time: 2019/3/19 16:41
 * description:
 */
public class ToolbarManager {

    private Context context;
    private View toolbar;

    private TextView tvTitle;

    private LinearLayout rootLeft;
    private ImageButton ibtnLeft;
    private TextView tvLeft;

    private LinearLayout rootRight;
    private ImageButton ibtnRight;
    private TextView tvRight;

    private View viewLine;

    private ToolbarManager(Context context, View toolbar) {
        this.context = context;
        this.toolbar = toolbar;
        tvTitle = toolbar.findViewById(R.id.toolbar_title);
        rootLeft = toolbar.findViewById(R.id.toolbar_left);
        ibtnLeft = toolbar.findViewById(R.id.toolbar_left_ibtn);
        tvLeft = toolbar.findViewById(R.id.toolbar_left_tv);

        rootRight = toolbar.findViewById(R.id.toolbar_right);
        ibtnRight = toolbar.findViewById(R.id.toolbar_right_ibtn);
        tvRight = toolbar.findViewById(R.id.toolbar_right_tv);

        viewLine = toolbar.findViewById(R.id.toolbar_line);
    }

    public static ToolbarManager create(Context context, View toolbar) {
        return new ToolbarManager(context, toolbar);
    }

    public ToolbarManager setBackground(@DrawableRes int drawable) {
        if (drawable != 0) {
            toolbar.setBackground(ContextCompat.getDrawable(context, drawable));
        }
        return this;
    }

    public ToolbarManager setBackgroundColor(@ColorRes int backgroundColor) {
        if (backgroundColor != 0) {
            toolbar.setBackgroundColor(context.getResources().getColor(backgroundColor));
        }
        return this;
    }

    public ToolbarManager setTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            tvTitle.setVisibility(View.VISIBLE);
            tvTitle.setText(title);
        }
        return this;
    }

    public ToolbarManager setTitle(@StringRes int titleId) {
        if (titleId != 0) {
            tvTitle.setVisibility(View.VISIBLE);
            tvTitle.setText(context.getString(titleId));
        }
        return this;
    }

    public ToolbarManager setTitleColor(@ColorRes int titleColor) {
        if (titleColor != 0) {
            tvTitle.setTextColor(context.getResources().getColor(titleColor));
        }
        return this;
    }

    public ToolbarManager setLeftText(String text) {
        if (!TextUtils.isEmpty(text)) {
            tvLeft.setVisibility(View.VISIBLE);
            tvLeft.setText(text);
        }
        return this;
    }

    public ToolbarManager setLeftText(@StringRes int textId) {
        if (textId != 0) {
            tvLeft.setVisibility(View.VISIBLE);
            tvLeft.setText(context.getString(textId));
        }
        return this;
    }


    public ToolbarManager setLeftTextColor(@ColorRes int colorId) {
        if (colorId != 0) {
            tvLeft.setTextColor(context.getResources().getColor(colorId));
        }
        return this;
    }

    public ToolbarManager setRightText(String text) {
        if (!TextUtils.isEmpty(text)) {
            tvRight.setVisibility(View.VISIBLE);
            tvRight.setText(text);
        }
        return this;
    }

    public ToolbarManager setRightText(@StringRes int textId) {
        if (textId != 0) {
            tvRight.setVisibility(View.VISIBLE);
            tvRight.setText(context.getString(textId));
        }
        return this;
    }

    public ToolbarManager setRightTextColor(@ColorRes int colorId) {
        if (colorId != 0) {
            tvRight.setTextColor(context.getResources().getColor(colorId));
        }
        return this;
    }


    public ToolbarManager setLeftButtonBackground(@DrawableRes int drawable) {
        if (drawable != 0) {
            ibtnLeft.setBackground(ContextCompat.getDrawable(context, drawable));
        }
        return this;
    }

    public ToolbarManager setRightButtonBackground(@DrawableRes int drawable) {
        if (drawable != 0) {
            ibtnRight.setBackground(ContextCompat.getDrawable(context, drawable));
        }
        return this;
    }

    public ToolbarManager setOnLeftClickListener(@Nullable View.OnClickListener l) {
        if (rootLeft != null) {
            rootLeft.setOnClickListener(l);
        }
        return this;
    }

    public ToolbarManager setOnLeftButtonClickListener(@Nullable View.OnClickListener l) {
        if (ibtnLeft != null) {
            ibtnLeft.setOnClickListener(l);
        }
        return this;
    }

    public ToolbarManager setOnLeftTextClickListener(@Nullable View.OnClickListener l) {
        if (tvLeft != null) {
            tvLeft.setOnClickListener(l);
        }
        return this;
    }


    public ToolbarManager setOnRightClickListener(@Nullable View.OnClickListener l) {
        if (rootRight != null) {
            rootRight.setOnClickListener(l);
        }
        return this;
    }

    public ToolbarManager setOnRightButtonClickListener(@Nullable View.OnClickListener l) {
        if (ibtnRight != null) {
            ibtnRight.setOnClickListener(l);
        }
        return this;
    }

    public ToolbarManager setOnRightTextClickListener(@Nullable View.OnClickListener l) {
        if (tvRight != null) {
            tvRight.setOnClickListener(l);
        }
        return this;
    }

    public ToolbarManager setLineColor(@ColorRes int colorId) {
        if (colorId != 0) {
            viewLine.setBackgroundColor(context.getResources().getColor(colorId));
        }
        return this;
    }

    public ToolbarManager setLineState(int visibility) {
        viewLine.setVisibility(visibility);
        return this;
    }
}
