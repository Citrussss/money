package com.jby.money.base.util;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

import com.binding.model.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

/**
 * @author user
 * @version $Rev$
 * @des 2018/7/13
 * @updateAuthor $Author$
 * @updateDes ${TODO}
 */
public class ContactsUtil {


    public static int sort(char[]ch1 ,char[] ch2) {
        int loop = Math.min(ch1.length, ch2.length);
        for (int i = 0; i < loop; i++) {
            char c1 = ch1[i];
            char c2 = ch2[i];
            if (c1 == c2)
                continue;
            if (isLetter(c1) == isLetter(c2))
                return c1 - c2;
            else if (isLetter(c2))
                return 1;
            else
                return -1;
        }
        return ch1.length - ch2.length;
    }

    public static boolean isLetter(char ch) {
        return (ch > 64 && ch < 91);
    }


    public static <R> List<R> getContacts(Context context, Function<Cursor, R> function) {
        List<R> list = new ArrayList<>();
        Cursor cursor = context.getContentResolver()
                .query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        null,
                        null,
                        null,
                        ContactsContract.Contacts.SORT_KEY_PRIMARY + " ASC");
        if (cursor != null) {
            while (cursor.moveToNext()) {
                try {
                    R r = function.apply(cursor);
                    list.add(r);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        FileUtil.close(cursor);
        return list;
    }

    @SuppressWarnings("unchecked")
    public static String getColumnIndex(Cursor cursor,String column){
            return cursor.getString(cursor.getColumnIndex(column));
    }


}


//    private void readContacts() {
//        Cursor cursor = null;
//        try {
//            //cursor指针 query询问 contract协议 kinds种类
//            cursor = context.getContentResolver()
//                    .query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
//                            null, null, null, ContactsContract.Contacts.SORT_KEY_PRIMARY+" ASC");
//            if (cursor != null) {
//                if (cursor.moveToFirst()) {
//                    do {
//                        String mobileContactsName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
//                        String mobilePhoneNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
//                        //                            ContactsEntity contactsEntity = new ContactsEntity();
//                        //                            if(TextUtils.isEmpty(BaseUtil.getPhoneError(mobilePhoneNumber.replaceAll(" ","")))){
//                        //                                contactsEntity.setNickname(mobileContactsName);
//                        //                                contactsEntity.setMobile(mobilePhoneNumber);
//                        //                                contactsList.add(contactsEntity);
//                        //                            }
//                    } while (cursor.moveToNext());
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (cursor != null) {
//                cursor.close();
//            }
//        }
//    }
