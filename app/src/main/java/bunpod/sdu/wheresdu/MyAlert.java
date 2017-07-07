package bunpod.sdu.wheresdu;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by ASUS PC on 7/7/2560.
 */

public class MyAlert {

    private Context context;

    public MyAlert(Context context) {
        this.context = context;
    }

    public void myDialog(String strTitle, String strMessage) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false); //ไม่ให้ปุ่ม Undo ทำงาน
        builder.setIcon(R.mipmap.ic_name); //สร้างรูปมาเป็นคำเตือน
        builder.setTitle(strTitle); //สร้างชื่อการเตือน
        builder.setMessage(strMessage); //สร้างข้อความเตือน
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        builder.show();


    } //การสร้าง PopUp

}// Main Class
