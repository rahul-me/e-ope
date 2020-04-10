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
 * Locale: BG (Bulgarian; български език)
 */
(function ($) {
	$.extend($.validator.messages, {
		required: "Полето е задължително.",
		remote: "Моля, въведете правилната стойност.",
		email: "Моля, въведете валиден email.",
		url: "Моля, въведете валидно URL.",
		date: "Моля, въведете валидна дата.",
		dateISO: "Моля, въведете валидна дата (ISO).",
		number: "Моля, въведете валиден номер.",
		digits: "Моля, въведете само цифри",
		creditcard: "Моля, въведете валиден номер на кредитна карта.",
		equalTo: "Моля, въведете същата стойност отново.",
		accept: "Моля, въведете стойност с валидно разширение.",
		maxlength: $.validator.format("Моля, въведете повече от {0} символа."),
		minlength: $.validator.format("Моля, въведете поне {0} символа."),
		rangelength: $.validator.format("Моля, въведете стойност с дължина между {0} и {1} символа."),
		range: $.validator.format("Моля, въведете стойност между {0} и {1}."),
		max: $.validator.format("Моля, въведете стойност по-малка или равна на {0}."),
		min: $.validator.format("Моля, въведете стойност по-голяма или равна на {0}.")
	});
}(jQuery));