package com.example.rabbitmq_demo.pojo;

import java.util.Date;

public class DataMQ {
    private Long sensor_id;
    private String sensor_type;
    private Integer sensor_type_code;
    private String location;
    private Double monitor_val;
    private String data_type;
    private String data_type_code;
    private String unit;
    private String sensor_status;
    private Integer sensor_status_code;
    private Date data_time;
    private Long mine_id;
    private Date insert_time;
    private String v_name;
    private Integer is_important;

    public Long getSensor_id() {
        return sensor_id;
    }

    public void setSensor_id(Long sensor_id) {
        this.sensor_id = sensor_id;
    }

    public String getSensor_type() {
        return sensor_type;
    }

    public void setSensor_type(String sensor_type) {
        this.sensor_type = sensor_type;
    }

    public Integer getSensor_type_code() {
        return sensor_type_code;
    }

    public void setSensor_type_code(Integer sensor_type_code) {
        this.sensor_type_code = sensor_type_code;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getMonitor_val() {
        return monitor_val;
    }

    public void setMonitor_val(Double monitor_val) {
        this.monitor_val = monitor_val;
    }

    public String getData_type() {
        return data_type;
    }

    public void setData_type(String data_type) {
        this.data_type = data_type;
    }

    public String getData_type_code() {
        return data_type_code;
    }

    public void setData_type_code(String data_type_code) {
        this.data_type_code = data_type_code;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSensor_status() {
        return sensor_status;
    }

    public void setSensor_status(String sensor_status) {
        this.sensor_status = sensor_status;
    }

    public Integer getSensor_status_code() {
        return sensor_status_code;
    }

    public void setSensor_status_code(Integer sensor_status_code) {
        this.sensor_status_code = sensor_status_code;
    }

    public Date getData_time() {
        return data_time;
    }

    public void setData_time(Date data_time) {
        this.data_time = data_time;
    }

    public Long getMine_id() {
        return mine_id;
    }

    public void setMine_id(Long mine_id) {
        this.mine_id = mine_id;
    }

    public Date getInsert_time() {
        return insert_time;
    }

    public void setInsert_time(Date insert_time) {
        this.insert_time = insert_time;
    }

    public String getV_name() {
        return v_name;
    }

    public void setV_name(String v_name) {
        this.v_name = v_name;
    }

    public Integer getIs_important() {
        return is_important;
    }

    public void setIs_important(Integer is_important) {
        this.is_important = is_important;
    }

    public DataMQ() {
    }

    public DataMQ(Long sensor_id, String sensor_type, Integer sensor_type_code, String location, Double monitor_val, String data_type, String data_type_code, String unit, String sensor_status, Integer sensor_status_code, Date data_time, Long mine_id, Date insert_time, String v_name, Integer is_important) {
        this.sensor_id = sensor_id;
        this.sensor_type = sensor_type;
        this.sensor_type_code = sensor_type_code;
        this.location = location;
        this.monitor_val = monitor_val;
        this.data_type = data_type;
        this.data_type_code = data_type_code;
        this.unit = unit;
        this.sensor_status = sensor_status;
        this.sensor_status_code = sensor_status_code;
        this.data_time = data_time;
        this.mine_id = mine_id;
        this.insert_time = insert_time;
        this.v_name = v_name;
        this.is_important = is_important;
    }

    @Override
    public String toString() {
        return "DataMQ{" +
                "sensor_id=" + sensor_id +
                ", sensor_type='" + sensor_type + '\'' +
                ", sensor_type_code=" + sensor_type_code +
                ", location='" + location + '\'' +
                ", monitor_val=" + monitor_val +
                ", data_type='" + data_type + '\'' +
                ", data_type_code='" + data_type_code + '\'' +
                ", unit='" + unit + '\'' +
                ", sensor_status='" + sensor_status + '\'' +
                ", sensor_status_code=" + sensor_status_code +
                ", data_time=" + data_time +
                ", mine_id=" + mine_id +
                ", insert_time=" + insert_time +
                ", v_name='" + v_name + '\'' +
                ", is_important=" + is_important +
                '}';
    }
}
