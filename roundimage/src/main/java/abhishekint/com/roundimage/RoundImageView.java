package abhishekint.com.roundimage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class RoundImageView extends ImageView {

    private int circleColor,circleTextColor;      //circle and text colors
    private String circleText;                    // circle text
    private Paint circlePaint,circlePaint2;                    // paint for drawing custom view
    private Context context;
    private AttributeSet attributeSet;
    public RoundImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        this.attributeSet=attrs;
        initView();
    }

    private void initView() {
        circlePaint=new Paint();                   //paint object for drawing in onDraw
        circlePaint2=new Paint();
        TypedArray  typedArray=context.getTheme().obtainStyledAttributes(attributeSet,R.styleable.RoundImageView,
                0,0);      //This typed array will provide access to the attribute values.
        circleText=typedArray.getString(R.styleable.RoundImageView_circleText);
        circleColor=typedArray.getColor(R.styleable.RoundImageView_circleColor,0);
        circleTextColor=typedArray.getColor(R.styleable.RoundImageView_circleTextColor,0);
        typedArray.recycle();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height=getMeasuredHeight();
        int width=getMeasuredWidth();
        int radius=0;
        if (height>width)
            radius=(width/2)-10;
        else
            radius=(height/2)-10;
        circlePaint.setColor(circleColor);
        canvas.drawCircle(width/2,height/2,radius,circlePaint);
        /*circlePaint2.setColor(getResources().getColor(R.color.colorAccent));
        canvas.drawOval(width/2,height/2,width/2,width/2,circlePaint2);*/
        circlePaint.setColor(circleTextColor);
        circlePaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(circleText,width/2,height/2,circlePaint);
    }

    public int getCircleColor() {
        return circleColor;
    }

    public int getCircleTextColor() {
        return circleTextColor;
    }

    public String getCircleText() {
        return circleText;
    }

    public void setCircleColor(int circleColor) {
        this.circleColor = circleColor;
        //make the onDraw method execute again, so that the new values affect the View.For that write below command
        invalidate();
        requestLayout();
    }

    public void setCircleTextColor(int circleTextColor) {
        this.circleTextColor = circleTextColor;
        invalidate();
        requestLayout();
    }

    public void setCircleText(String circleText) {
        this.circleText = circleText;
        invalidate();
        requestLayout();
    }
}
