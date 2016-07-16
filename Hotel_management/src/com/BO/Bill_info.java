package com.BO;

public class Bill_info {
public static float Service_TAX=6.5f;
private int Bill_no;
private int Table_no;
private int Pax;
private int Steward_id;
private String Department;
private String Guest_name;
private String Steward_name;
private String Date;
private String Time;
private int Discount;
private float Service_tax;
private float Price_After_discount;
private float Total_price;
public int getBill_no() {
	return Bill_no;
}
public void setBill_no(int bill_no) {
	Bill_no = bill_no;
}
public int getTable_no() {
	return Table_no;
}
public void setTable_no(int table_no) {
	Table_no = table_no;
}
public int getPax() {
	return Pax;
}
public void setPax(int pax) {
	Pax = pax;
}
public int getSteward_id() {
	return Steward_id;
}
public void setSteward_id(int steward_id) {
	Steward_id = steward_id;
}
public String getDepartment() {
	return Department;
}
public void setDepartment(String department) {
	Department = department;
}
public String getGuest_name() {
	return Guest_name;
}
public void setGuest_name(String guest_name) {
	Guest_name = guest_name;
}
public String getSteward_name() {
	return Steward_name;
}
public void setSteward_name(String steward_name) {
	Steward_name = steward_name;
}
public String getDate() {
	return Date;
}
public void setDate(String date) {
	Date = date;
}
public String getTime() {
	return Time;
}
public void setTime(String time) {
	Time = time;
}
public int getDiscount() {
	return Discount;
}
public void setDiscount(int discount) {
	Discount = discount;
}
public float getService_tax() {
	return Service_tax;
}
public void setService_tax(float service_tax) {
	Service_tax = service_tax;
}
public float getPrice_After_discount() {
	return Price_After_discount;
}
public void setPrice_After_discount(float price_After_discount) {
	Price_After_discount = price_After_discount;
}
public float getTotal_price() {
	return Total_price;
}
public void setTotal_price(float total_price) {
	Total_price = total_price;
}
}
