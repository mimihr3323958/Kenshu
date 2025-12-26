package com.example.moattravel.form;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data

public class ReservationInputForm {
	
	@NotBlank(message = "チェックイン日とチェックアウト日を選択してください。")
	
	private String fromCheckinDateToCheckoutDate;
	
	@NotNull(message = "宿泊人数を入力してください。")
	private Integer numberOfPeople;
	
	//チェックイン日を取得する
	public LocalDate getCheckinDate() {
		
		String[] checkinDateAndCheckoutDate = getFromCheckinDateToCheckoutDate().split("から");
		
		return LocalDate.parse(checkinDateAndCheckoutDate[0]);
	}
	
	//チェックアウト日を取得する
	public LocalDate getCheckoutDate() {
		
		String[] checkinDateAndCheckoutDate = getFromCheckinDateToCheckoutDate().split("から");
		
		return LocalDate.parse(checkinDateAndCheckoutDate[1]);
	}

}
