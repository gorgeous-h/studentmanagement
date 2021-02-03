package com.yhpt.studentmanagement.common.tree;

/**
 * @Author: hjj
 * @Date: 2020/11/16 15:58
 * @Description:
 */
public class TreeNode {
    private Integer id;
    private String text;
    private boolean checked; // 节点是否选中

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
