package com.cmkj.mall.common.constant.states;

/**
 * @author swallowff
 * @create 2019/10/15
 */
public interface CommonStatusEnums {

    enum DeleteStatus{
        NORMAL(0),
        DELETED(1);

        private Integer val;

        DeleteStatus(Integer val) {
            this.val = val;
        }

        public Integer getVal() {
            return val;
        }

        public void setVal(Integer val) {
            this.val = val;
        }
    }

}
