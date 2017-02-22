package com.skyzone.netdemomvp.ServiceDemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * 所有的service都必须在清单文件中声明
 * Created by Skyzone on 2/20/2017.
 */

public class DownLoadService extends Service {

    /**
     * 允许组件启动服务，使用Context.startService(Intent)时，该服务不受组件的销毁的影响，知道任务结束才会销毁，该服务的结果不会回调给组件处理
     *
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * 允许组件绑定服务，多个组件可以同时绑定到一个服务，但全部解绑后，该服务销毁，同时组件可以和服务交互，可以处理结果，发送请求
     *
     * @param intent
     * @return
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
