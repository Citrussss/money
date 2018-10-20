package com.jby.money.ui.user;


import com.binding.model.model.ViewInflate;
import com.binding.model.model.inter.Inflate;

/**
 * @name money
 * @class name：com.jby.money.ui.user
 * @class describe
 * @anthor bangbang QQ:740090077
 * @time 2018/10/20 5:57 PM
 * @change
 * @chang time
 * @class describe
 */
public class UserEntity extends ViewInflate {

    /**
     * id : 1
     * mobile : 111
     * password : 22
     */

    private int id;
    private int mobile;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
