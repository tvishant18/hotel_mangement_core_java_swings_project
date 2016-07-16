package com.BO;

public class KOT_info {
private int KOT_no;
private int Table_no;
private String Item_code;
private String Item_name;
private float Quantity;
private float Price;
private String Date;
private String Department;
private float total_price;
private float total_cost;
private int sr_no;
public int getSr_no() {
	return sr_no;
}
public void setSr_no(int sr_no) {
	this.sr_no = sr_no;
}
public float getTotal_cost() {
	return total_cost;
}
public void setTotal_cost(float total_cost) {
	this.total_cost = total_cost;
}
private int Steward_id;
private float Vat;
public float getVat() {
	return Vat;
}
public void setVat(float vat) {
	Vat = vat;
}
public int getSteward_id() {
	return Steward_id;
}
public void setSteward_id(int steward_id) {
	Steward_id = steward_id;
}
public String getSteward_name() {
	return Steward_name;
}
public void setSteward_name(String steward_name) {
	Steward_name = steward_name;
}
private String Steward_name;
public float getTotal_price() {
	return total_price;
}
public void setTotal_price(float total_price) {
	this.total_price = total_price;
}
public int getKOT_no() {
	return KOT_no;
}
public void setKOT_no(int kOT_no) {
	KOT_no = kOT_no;
}
public int getTable_no() {
	return Table_no;
}
public void setTable_no(int table_no) {
	Table_no = table_no;
}
public String getItem_code() {
	return Item_code;
}
public void setItem_code(String item_code) {
	Item_code = item_code;
}
public String getItem_name() {
	return Item_name;
}
public void setItem_name(String item_name) {
	Item_name = item_name;
}
public float getQuantity() {
	return Quantity;
}
public void setQuantity(float quantity) {
	Quantity = quantity;
}
public float getPrice() {
	return Price;
}
public void setPrice(float price) {
	Price = price;
}
public String getDate() {
	return Date;
}
public void setDate(String date) {
	Date = date;
}
public String getDepartment() {
	return Department;
}
public void setDepartment(String department) {
	Department = department;
}

}
