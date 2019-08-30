package com.projectcompany.Projectname.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.projectcompany.Projectname.config.JsonDateDeserializer;
import com.projectcompany.Projectname.config.JsonDateSerializer;

import lombok.Data;

@Entity
@Data
@Table(name="SRC.TRANSACTION")
public class Transaction {
	@Id
	private String transaction_key;
	
	private String transaction_id;
	
	@JsonDeserialize(using = JsonDateDeserializer.class)
	@JsonSerialize(using = JsonDateSerializer.class)
	private java.util.Date transaction_date;
	
	@JsonDeserialize(using = JsonDateDeserializer.class)
	@JsonSerialize(using = JsonDateSerializer.class)
	private java.util.Date transaction_time;
	
	private String account_key;

	private Float amount;

	private String currency_code;

	private String direction;

	private String transaction_type;

	private String channel_type;

	private String channel_id;

	private String transaction_reference_number;

	private String transaction_purpose;

	private String transaction_description;

	private String execution_branch_code;

	private String executer_id;

	private String surrogate_id;

	private String surrogate_id_type;

	private String surrogate_name;

	private String domain_id;

	private String segment_id;

	private String CREDIT_CARD_BILL_STATEMENT_MONTH;

	private Float fund_number_unit;

	private Float fund_principal_amount;
}
