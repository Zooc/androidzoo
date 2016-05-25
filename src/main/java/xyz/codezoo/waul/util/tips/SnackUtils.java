package xyz.codezoo.waul.util.tips;

import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

import xyz.codezoo.waul.R;

/**
 * Created by Kenny on 2015/12/25 15:54
 */
public class SnackUtils {


    private static View getSnackBarView(Snackbar snackbar) {
        return snackbar.getView();
    }

    /**
     * get message text view
     *
     * @param snackbar
     * @return
     */
    public static TextView getSnackbarMsgView(Snackbar snackbar) {
        View tvMsg = getSnackBarView(snackbar).findViewById(R.id.snackbar_text);
        if (tvMsg instanceof TextView) {
            return (TextView) tvMsg;
        }
        return null;
    }

    public static Snackbar getSnackBar(View view, String message, int time) {
        return Snackbar.make(view, message, time);
    }

    public static void showMessage(View view, String message, int time) {
        Snackbar snackBar = getSnackBar(view, message, time);
        snackBar.show();
    }

    public static void showMessage(View view, String message, int time, int... resId) {
        Snackbar snackBar = getSnackBar(view, message, time);
        if (resId.length > 0) {
            setSnackbarStyle(snackBar, resId);
        }
        snackBar.show();
    }

    public static void showMessage(Snackbar snackbar, int... resId) {
        if (resId.length > 0)
            setSnackbarStyle(snackbar, resId);
        snackbar.show();
    }

    /**
     * set Snackbar style
     *
     * @param snackBar
     * @param resId    index 0 : view background index 1 ：message text color
     */
    public static void setSnackbarStyle(Snackbar snackBar, int[] resId) {
        View contentView = getSnackBarView(snackBar);
        if (contentView != null && resId[0] != 0) {
            contentView.setBackgroundResource(resId[0]);
        }
        if (resId.length > 1 && resId[1] != 0) {
            TextView tvMsg = getSnackbarMsgView(snackBar);
            if (tvMsg != null) {
                tvMsg.setTextColor(contentView.getResources().getColor(resId[1]));
            }
        }
    }

    public static void showWihteTextMessage(Snackbar snackbar, int... resId) {
        int viewBackgroundId = 0;
        if (resId.length > 0)
            viewBackgroundId = resId[0];
        showMessage(snackbar, viewBackgroundId, R.color.white);
    }

    /**
     * success green
     * failure red
     * error blue
     * common grey
     */

    public static void showSuccessMessage(View view, String message, int time) {
        showSuccessMessage(getSnackBar(view, message, time));
    }

    public static void showFailureMessage(View view, String message, int time) {
        showFailureMessage(getSnackBar(view, message, time));
    }

    public static void showErrorMessage(View view, String message, int time) {
        showErrorMessage(getSnackBar(view, message, time));
    }

    public static void showCommonMessage(View view, String message, int time) {
        showCommonMessage(getSnackBar(view, message, time));
    }

    public static void showSuccessMessage(Snackbar snackbar) {
        showWihteTextMessage(snackbar, R.color.success);
    }

    public static void showFailureMessage(Snackbar snackbar) {
        showWihteTextMessage(snackbar, R.color.failure);
    }

    public static void showErrorMessage(Snackbar snackbar) {
        showWihteTextMessage(snackbar, R.color.error);
    }

    public static void showCommonMessage(Snackbar snackbar) {
        showWihteTextMessage(snackbar, R.color.common);
    }


}
