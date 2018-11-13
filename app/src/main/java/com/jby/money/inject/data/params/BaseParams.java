package com.jby.money.inject.data.params;

import com.jby.money.ui.user.User;

/**
 * @name money
 * @class name：com.jby.money.inject.data.params
 * @class describe
 * @anthor bangbang QQ:740090077
 * @time 2018/10/4 12:58 PM
 * @change
 * @chang time
 * @class describe
 */
interface BaseParams {
     String token = User.getToken();
}
