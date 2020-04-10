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
 * Locale: HE (Hebrew; עברית)
 */
(function ($) {
	$.extend($.validator.messages, {
		required: "השדה הזה הינו שדה חובה",
		remote: "נא לתקן שדה זה",
		email: "נא למלא כתובת דוא\"ל חוקית",
		url: "נא למלא כתובת אינטרנט חוקית",
		date: "נא למלא תאריך חוקי",
		dateISO: "נא למלא תאריך חוקי (ISO)",
		number: "נא למלא מספר",
		digits: "נא למלא רק מספרים",
		creditcard: "נא למלא מספר כרטיס אשראי חוקי",
		equalTo: "נא למלא את אותו ערך שוב",
		accept: "נא למלא ערך עם סיומת חוקית",
		maxlength: $.validator.format(".נא לא למלא יותר מ- {0} תווים"),
		minlength: $.validator.format("נא למלא לפחות {0} תווים"),
		rangelength: $.validator.format("נא למלא ערך בין {0} ל- {1} תווים"),
		range: $.validator.format("נא למלא ערך בין {0} ל- {1}"),
		max: $.validator.format("נא למלא ערך קטן או שווה ל- {0}"),
		min: $.validator.format("נא למלא ערך גדול או שווה ל- {0}")
	});
}(jQuery));