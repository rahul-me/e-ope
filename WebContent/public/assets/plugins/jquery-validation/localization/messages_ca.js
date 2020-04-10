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
 * Locale: CA (Catalan; català)
 */
(function ($) {
	$.extend($.validator.messages, {
		required: "Aquest camp és obligatori.",
		remote: "Si us plau, omple aquest camp.",
		email: "Si us plau, escriu una adreça de correu-e vàlida",
		url: "Si us plau, escriu una URL vàlida.",
		date: "Si us plau, escriu una data vàlida.",
		dateISO: "Si us plau, escriu una data (ISO) vàlida.",
		number: "Si us plau, escriu un número enter vàlid.",
		digits: "Si us plau, escriu només dígits.",
		creditcard: "Si us plau, escriu un número de tarjeta vàlid.",
		equalTo: "Si us plau, escriu el maateix valor de nou.",
		accept: "Si us plau, escriu un valor amb una extensió acceptada.",
		maxlength: $.validator.format("Si us plau, no escriguis més de {0} caracters."),
		minlength: $.validator.format("Si us plau, no escriguis menys de {0} caracters."),
		rangelength: $.validator.format("Si us plau, escriu un valor entre {0} i {1} caracters."),
		range: $.validator.format("Si us plau, escriu un valor entre {0} i {1}."),
		max: $.validator.format("Si us plau, escriu un valor menor o igual a {0}."),
		min: $.validator.format("Si us plau, escriu un valor major o igual a {0}.")
	});
}(jQuery));