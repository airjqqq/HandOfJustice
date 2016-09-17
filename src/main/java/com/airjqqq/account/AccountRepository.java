package com.airjqqq.account;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Airj on 2016/9/15.
 */
interface AccountRepository extends MongoRepository<Account,String> {
}
