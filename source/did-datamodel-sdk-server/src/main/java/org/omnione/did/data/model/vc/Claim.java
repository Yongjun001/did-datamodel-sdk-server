/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.vc;

import java.util.Map;

import jakarta.validation.constraints.NotEmpty;

import org.omnione.did.data.model.DataObject;
import org.omnione.did.data.model.util.json.GsonWrapper;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 
 */

@Getter
@Setter
public class Claim extends DataObject {

	/**
	 * code
	 */
	@SerializedName("code")
	@Expose @NotEmpty
	private String code;

	/**
	 * code name
	 */
	@SerializedName("caption")
	@Expose @NotEmpty
	private String caption;

	/**
	 * 
	 */
	@SerializedName("value")
	@Expose
	private String value;

	/**
	 * ClaimType enum value
	 */
	@SerializedName("type")
	@Expose @NotEmpty
	private String type;

	/**
	 * ClaimFormat enum value
	 */
	@SerializedName("format")
	@Expose @NotEmpty
	private String format;

	/**
	 * true - non display
	 */
	@SerializedName("hideValue")
	@Expose
	private boolean hideValue;

	/**
	 * Location enum value
	 */
	@SerializedName("location")
	@Expose 
	private String location;

	/**
	 * Required unless location is "inline"
	 * W3C subresource integrity
	 * format : {hashAlgorithm} - {hashBase64} 
	 */
	@SerializedName("digestSRI")
	@Expose
	private String digestSRI;

	/**
	 * Multilingual information
	 */
	@SerializedName("i18n")
	@Expose
	private Map<String, I18N> i18n;

	@Override
	public void fromJson(String val) {
		GsonWrapper gson = new GsonWrapper();
		Claim data = gson.fromJson(val, Claim.class);

		code = data.code;
		caption = data.caption;
		value = data.value;
		type = data.type;
		format = data.format;
		hideValue = data.hideValue;
		location = data.location;
		digestSRI = data.digestSRI;
		i18n = data.i18n;

	}

}
