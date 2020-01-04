package myProjects02.service;
import java.util.Arrays;
import myProjects02.bean.Customer;

/**
 * 
 * @Description CustomerList为Customer对象的管理模块，内部用数组管理一组Customer对象，
 *              并提供相应的添加、修改、删除和遍历方法，供CustomerView调用
 * @author etsugatsukoshietsu
 * @date Jan 1, 2020 3:03:15 PM
 * @version
 */
public class CustomerList {
	private Customer[] customers;
	private int total = 0;

	public CustomerList(int totalCustomer) {
		customers = new Customer[totalCustomer];
	}

	/**
	 * @Description 将参数customer添加到数组中最后一个客户对象记录之后
	 * @author etsugatsukoshietsu
	 * @date Jan 3, 2020 11:12:54 AM
	 * @param customer
	 * @return true: 添加成功 false添加失败
	 */
	public boolean addCustomer(Customer customer) {
		if (total >= customers.length)
			return false;
		customers[total++] = customer;
		return true;
	}

	/**
	 * 
	 * @Description 用参数customer替换数组中由index指定的对象
	 * @author etsugatsukoshietsu
	 * @date Jan 3, 2020 11:20:29 AM
	 * @param index
	 * @param cust
	 * @return 替换成功返回true；false表示索引无效，无法替换
	 */
	public boolean replaceCustomer(int index, Customer cust) {
		if (index < 0 || index >= total) return false;
		customers[index] = cust;
		return true;
	}
	/**
	 * 
	 * @Description 从数组中删除参数index指定索引位置的客户对象记录
	 * @author etsugatsukoshietsu 
	 * @date Jan 3, 2020 11:26:59 AM
	 * @param index
	 * @return true表示删除成功 false表示删除失败
	 */
	public boolean deleteCustomer(int index) {
		if (index < 0 && index >= total ) return false;
		for(int i = total - 1; i>index; i--) {
			customers[i-1] = customers[i];
		}
		customers[total--] =null;
		return true;
	}

	public Customer[] getAllCustomers() {
		return customers;
	}

	public Customer getCustomer(int index) {
		if(index < 0 || index >= total) return null;
		return customers[index];
	}

	public int getTotal() {
		return total;
	}

}
