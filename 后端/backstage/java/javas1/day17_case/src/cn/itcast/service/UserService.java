package cn.itcast.service;

import cn.itcast.domain.PageBean;
import cn.itcast.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户管理的业务接口
 */
public interface UserService {
    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();
    public User login(User user);

    /**
     * 保存User
     * @param user
     */
    void addUser(User user);

    /**
     * 根据id删除User
     * @param id
     */
    void deleteUser(String id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public User findUserById(String id);

    /**
     * 修改用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 批量删除用户
     * @param ids
     */
    void delSelectedUser(String[] ids);

    /**
     * 分页条件查询
     * @param _currentPage
     * @param _rows
     * @param condition
     * @return
     */
    PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition);
}
