package com.dqr.www.multitypestudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.dqr.www.multitypestudy.blibli.BlibliActivity;
import com.dqr.www.multitypestudy.multi_select.MultiSelectActivity;
import com.dqr.www.multitypestudy.normal.NormalActivity;
import com.dqr.www.multitypestudy.one2many.OneToManyActivity;
import com.dqr.www.multitypestudy.weibo.WeiboActivity;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-05-11 20:52
 */

public class MenuBaseActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent();
        switch (item.getItemId()){
            case R.id.NormalActivity:
                intent.setClass(this, NormalActivity.class);
                break;
            case R.id.MultiSelectActivity:
                intent.setClass(this, MultiSelectActivity.class);
                break;
            case R.id.BilibiliActivity:
                intent.setClass(this, BlibliActivity.class);
                break;
            case R.id.OneDataToManyActivity:
                intent.setClass(this,OneToManyActivity.class);
                break;
            case R.id.WeiboActivity:
                intent.setClass(this,WeiboActivity.class);
                break;
        }
        startActivity(intent);
        this.finish();
        return super.onOptionsItemSelected(item);
    }
}
