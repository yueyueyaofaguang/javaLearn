package myProjects02.ui;
import java.util.jar.Attributes.Name;

import myProjects02.bean.Customer;
import myProjects02.service.CustomerList;
import myProjects02.util.CMUtility;;
/**
 * 
 * @Description
 * @author etsugatsukoshietsu
 * @date Jan 2, 202011:12:13 PM
 * @version
 */
public class CustomerView {
	private CustomerList customerList = new CustomerList(10);
	public void enterMainMenu() {
		Boolean flag = true;
		while(flag) {
		System.out.println("-------------------------客户信息管理软件-----------------\n" + "");
		System.out.println("                        1 添 加 客 户");
		System.out.println("                        2 修 改 客 户");
		System.out.println("                        3 删 除 客 户");
		System.out.println("                        4 客 户 列 表");
		System.out.println("                        5 退 出");
		System.out.println("                        请选择(1-5)");
		char result = CMUtility.readMenuSelection();
		switch (result) {
		case '1':
			addNewCustomer();
			break;
		case '2':
			modifyCustomer();
			break;
		case '3':
			deleteCustomer();
			break;
		case '4':
			listAllCustomers();
			break;
		case '5':
			System.out.println("确定要退出？(Y?N)");
			if(CMUtility.readConfirmSelection()=='Y') {
				flag = false;
			};
			break;
		}
		}
	}
	private void addNewCustomer() {
		System.out.println("---------------------添加客户-----------------------");
		String name;
		char sex;
		int age;
		String phone;
		String email;
		Customer cus;
		System.out.println("姓名:");
		name = CMUtility.readString(10);
		System.out.println("性别:");
		sex = CMUtility.readChar();
		System.out.println("年龄");
		age = CMUtility.readInt();
		System.out.println("电话");
		phone = CMUtility.readString(11);
		System.out.println("邮箱");
		email = CMUtility.readString(20);
		cus = new Customer(name,sex,age,phone,email);
		if(customerList.addCustomer(cus)) {
			System.out.println("---------------------添加成功-----------------------");
		}
		}
	private void modifyCustomer() {
		String name;
//		char sex;
//		int age;
//		String phone;
//		String email;
//		System.out.println("---------------------修改客户-----------------------");
//		System.out.println("请选择待修改客户编号(-1退出)：");
//		int result = CMUtility.readInt();
//		if(result!= -1) {
//			Customer cust = customerList.getCustomer(result);
//			System.out.println("姓名("+cust.getName()+")");
//			name = CMUtility.readString(10,"");
//			if(!name.isEmpty()) {
//				cust.setName(name);
//			};
//			System.out.println("性别("+cust.getSex()+")");
//			sex = CMUtility.readChar();
//		}
	}
	private void deleteCustomer() {
		System.out.println("---------------------删除客户-----------------------");
		System.out.println("请选择待删除客户编号(-1退出)：");
		int result = CMUtility.readInt();
		if(result!= -1) {
			System.out.println("确认是否删除(Y/N)");
			if(CMUtility.readConfirmSelection() == 'Y') {
				if(customerList.deleteCustomer(result)) {
					System.out.println("---------------------删除完成-----------------------");
				};
			};
		}
	}
	private void listAllCustomers() {
		System.out.println("---------------------客户列表-------------------");
		Customer cus[] = customerList.getAllCustomers();
//		Boolean empty = true;
//		for (int i = 0; i < cus.length; i++) {
//			if(cus[i]!= null) 
//				empty = false;
//		}
		if(customerList.getTotal() == 0) {
			System.out.println("---------------------暂无客户信息-------------------");
			return;
		}
		System.out.println("编号\t姓名\t性\t年龄\t电话\t邮箱");
		for (int i = 0; i < cus.length; i++) {
			System.out.println(i +"      "+ cus[i].getName() + "        "+cus[i].getSex()+"       "+ cus[i].getAge() + "           "+cus[i].getPhone()+ "            "+cus[i].getEmail()
);
		}
		System.out.println("---------------------客户列表完成-------------------");
	}
	public static void main(String[] args) {
		CustomerView view1 = new CustomerView();
		view1.enterMainMenu();
	}
}
