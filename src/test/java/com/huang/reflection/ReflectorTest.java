package com.huang.reflection;

import com.huang.reflection.wrapper.Reflector;

/**
 * Created by fenfanxiadewunai on 14-6-3.
 */
public class ReflectorTest {


    public static void main(String[] args) {
        Reflector reflector = Reflector.forClass(Section.class);
        System.out.println(reflector.getSetterType("id"));
    }

    static interface Entity<T> {
        T getId();
        void setId(T id);
    }

    static abstract class AbstractEntity implements Entity<Long> {

        private Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }

//    static class Section extends AbstractEntity implements Entity<Long> {
//
//    }

    static class Section implements Entity<Long>{
        private Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }
}
