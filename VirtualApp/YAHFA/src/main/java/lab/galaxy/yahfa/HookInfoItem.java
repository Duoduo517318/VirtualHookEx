package lab.galaxy.yahfa;

/**
 * Created by Gsang on 2018/6/26.
 */

public class  HookInfoItem{
    public String   hookPackageName;
    public String[] hookItemNames;
    public HookInfoItem(String packname, String[] hook_items){
        hookPackageName = packname;
        hookItemNames =  hook_items;
    }

}
