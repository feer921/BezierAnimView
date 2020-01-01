package com.fee.bezieranimview;

import android.animation.Animator;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements BezierAnimView.IBezierAnimControler{
    private BezierAnimView bezierAnimView;
    private int[] lovingHeartIconResIds = {
            R.drawable.loving_heart_72px,
            R.drawable.love_heart_2,
            R.drawable.love_heart3,
            R.drawable.loving_heart_04,
            R.drawable.loving_heart_05,
            R.drawable.loving_heart_06,
            R.drawable.loving_heart_07,
            R.drawable.loving_heart_8,
            R.drawable.loving_heart_9
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        bezierAnimView = findViewById(R.id.bezier_anim_view);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * 甚至可以由外部来提供承载动画的View
     *
     * @param theBezierAnimView 当前的动画视图(舞台)
     * @return 提供的承载动画的View；最佳实践为: 每次都是新对象
     */
    @Override
    public View provideHoldAnimView(BezierAnimView theBezierAnimView) {
        return null;
    }

    /**
     * 外部提供 要精确控制本 贝塞尔曲线动画的关键点信息
     *
     * @param theBezierAnimView 当前的动画视图(舞台)
     * @param animIconWidth     动画资源的宽，便于计算关键点坐标; 也可以不参考该参数
     * @param animIconHeight    动画资源的高、便于计算关键点坐标; 也可以不参考该参数
     * @return 关键点集合，目前本类仅支持最多4个点的关键点信息，List<0> = 初始坐标点；List<1> 整个曲线的中间控制点第1点--最关键；
     * List<2> 整个曲线的中间控制点第1点--也最关键；List<3>: 整个曲线的终点；
     */
    @Override
    public List<PointF> provideKeyPoints(BezierAnimView theBezierAnimView, int animIconWidth, int animIconHeight) {
        return null;
    }

    /**
     * 可选项：提供一个当 承载动画的View开始显示出来时是否要有的动画
     *
     * @param theBezierAnimView 当前的动画视图(舞台)
     * @param holdTheAnimView   承载动画的View
     * @return Animator
     */
    @Override
    public Animator provideFirstShowAnimator(BezierAnimView theBezierAnimView, View holdTheAnimView) {
        return null;
    }

    /**
     * 贝塞尔曲线动画 状态的回调
     *
     * @param theBezierAnimView   当前的动画视图(舞台)
     * @param theAnimView         当前动画的Veiw
     * @param curPointF           当前的坐标
     * @param curAnimatedFraction 当前动画完成的系数： 1时为完成；
     */
    @Override
    public void onAnimStateUpdated(BezierAnimView theBezierAnimView, View theAnimView, PointF curPointF, float curAnimatedFraction) {

    }

    /**
     * 可选项：提供一个 和当贝塞尔曲线动画开始时一起/同时执行的动画
     *
     * @param theBezierAnimView 当前的动画视图(舞台)
     * @param holdTheAnimView   承载动画的View
     * @return Animator
     */
    @Override
    public Animator provideAnimatorPlayWithBezierAnim(BezierAnimView theBezierAnimView, View holdTheAnimView) {
        return null;
    }
}
