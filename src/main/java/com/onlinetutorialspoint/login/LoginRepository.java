package com.onlinetutorialspoint.login;

import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<LoginForm,String> {
}
