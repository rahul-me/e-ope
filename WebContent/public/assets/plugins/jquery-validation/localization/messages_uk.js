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
 * Locale: UK (Ukrainian; українська мова)
 */
(function ($) {
	$.extend($.validator.messages, {
		required: "Це поле необхідно заповнити.",
		remote: "Будь ласка, введіть правильне значення.",
		email: "Будь ласка, введіть коректну адресу електронної пошти.",
		url: "Будь ласка, введіть коректний URL.",
		date: "Будь ласка, введіть коректну дату.",
		dateISO: "Будь ласка, введіть коректну дату у форматі ISO.",
		number: "Будь ласка, введіть число.",
		digits: "Вводите потрібно лише цифри.",
		creditcard: "Будь ласка, введіть правильний номер кредитної карти.",
		equalTo: "Будь ласка, введіть таке ж значення ще раз.",
		accept: "Будь ласка, виберіть файл з правильним розширенням.",
		maxlength: $.validator.format("Будь ласка, введіть не більше {0} символів."),
		minlength: $.validator.format("Будь ласка, введіть не менше {0} символів."),
		rangelength: $.validator.format("Будь ласка, введіть значення довжиною від {0} до {1} символів."),
		range: $.validator.format("Будь ласка, введіть число від {0} до {1}."),
		max: $.validator.format("Будь ласка, введіть число, менше або рівно {0}."),
		min: $.validator.format("Будь ласка, введіть число, більше або рівно {0}.")
	});
}(jQuery));