package com.huang.reflection;

/**
 * Created by fenfanxiadewunai on 14-6-5.
 */
public abstract class AbstractEntity implements Entity<Long>{
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
