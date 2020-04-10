/*******************************************************************************
 * Gridscape Solutions, Inc. - CONFIDENTIAL & PROPRIETARY
 * --------------------------
 * [2015] - [2020] Gridscape Solutions, Inc.
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Gridscape Solutions, Inc.
 * The intellectual and technical concepts contained
 * herein are proprietary to Gridscape Solutions, Inc.
 * and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Gridscape Solutions.
 *******************************************************************************/
 
  
  
/*
 * Translated default messages for the jQuery validation plugin.
 * Locale: RU (Russian; русский язык)
 */
(function ($) {
	$.extend($.validator.messages, {
		required: "Это поле необходимо заполнить.",
		remote: "Пожалуйста, введите правильное значение.",
		email: "Пожалуйста, введите корректный адрес электронной почты.",
		url: "Пожалуйста, введите корректный URL.",
		date: "Пожалуйста, введите корректную дату.",
		dateISO: "Пожалуйста, введите корректную дату в формате ISO.",
		number: "Пожалуйста, введите число.",
		digits: "Пожалуйста, вводите только цифры.",
		creditcard: "Пожалуйста, введите правильный номер кредитной карты.",
		equalTo: "Пожалуйста, введите такое же значение ещё раз.",
		accept: "Пожалуйста, выберите файл с правильным расширением.",
		maxlength: $.validator.format("Пожалуйста, введите не больше {0} символов."),
		minlength: $.validator.format("Пожалуйста, введите не меньше {0} символов."),
		rangelength: $.validator.format("Пожалуйста, введите значение длиной от {0} до {1} символов."),
		range: $.validator.format("Пожалуйста, введите число от {0} до {1}."),
		max: $.validator.format("Пожалуйста, введите число, меньшее или равное {0}."),
		min: $.validator.format("Пожалуйста, введите число, большее или равное {0}.")
	});
}(jQuery));