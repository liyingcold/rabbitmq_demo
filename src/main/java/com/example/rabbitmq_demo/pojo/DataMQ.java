package com.example.rabbitmq_demo.pojo;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
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

}
