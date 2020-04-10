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
 * Locale: TH (Thai; ไทย)
 */
(function ($) {
	$.extend($.validator.messages, {
		required: "โปรดระบุ",
		remote: "โปรดแก้ไขให้ถูกต้อง",
		email: "โปรดระบุที่อยู่อีเมล์ที่ถูกต้อง",
		url: "โปรดระบุ URL ที่ถูกต้อง",
		date: "โปรดระบุวันที่ ที่ถูกต้อง",
		dateISO: "โปรดระบุวันที่ ที่ถูกต้อง (ระบบ ISO).",
		number: "โปรดระบุทศนิยมที่ถูกต้อง",
		digits: "โปรดระบุจำนวนเต็มที่ถูกต้อง",
		creditcard: "โปรดระบุรหัสบัตรเครดิตที่ถูกต้อง",
		equalTo: "โปรดระบุค่าเดิมอีกครั้ง",
		accept: "โปรดระบุค่าที่มีส่วนขยายที่ถูกต้อง",
		maxlength: $.validator.format("โปรดอย่าระบุค่าที่ยาวกว่า {0} อักขระ"),
		minlength: $.validator.format("โปรดอย่าระบุค่าที่สั้นกว่า {0} อักขระ"),
		rangelength: $.validator.format("โปรดอย่าระบุค่าความยาวระหว่าง {0} ถึง {1} อักขระ"),
		range: $.validator.format("โปรดระบุค่าระหว่าง {0} และ {1}"),
		max: $.validator.format("โปรดระบุค่าน้อยกว่าหรือเท่ากับ {0}"),
		min: $.validator.format("โปรดระบุค่ามากกว่าหรือเท่ากับ {0}")
	});
}(jQuery));