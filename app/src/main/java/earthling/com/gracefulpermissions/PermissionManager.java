package earthling.com.gracefulpermissions;

/**
 * Created by dinuka on 03/04/2017.
 */

public class PermissionManager {
    private Context context;
    private Activity activity;

    public PermissionManager(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    }

    public boolean hasPermission(String permission) {
        if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
            return false;
        } else {
            return true;
        }
    }

    public void handlePermissions(String[] permissions) {

        ArrayList<String> permissionsNeeded = new ArrayList<>();
        //check if the permissions are granted already
        for (String permission : permissions) {
            if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                permissionsNeeded.add(permission);
            }
        }

        //request the required permissions
        if(permissionsNeeded.size() != 0) {
            ActivityCompat.requestPermissions(activity, permissionsNeeded.toArray(new String[0]), 112);
        }
    }

    private boolean canMakeSmores() {
        return(Build.VERSION.SDK_INT>Build.VERSION_CODES.LOLLIPOP_MR1);
    }
}
