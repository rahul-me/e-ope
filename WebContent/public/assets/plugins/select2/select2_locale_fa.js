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
 
  
  
/**
 * Select2 <fa> translation.
 * 
 * Author: Ali Choopan <choopan@arsh.co>
 */
(function ($) {
    "use strict";

    $.extend($.fn.select2.defaults, {
        formatNoMatches: function () { return "نتیجه‌ای یافت نشد."; },
        formatInputTooShort: function (input, min) { var n = min - input.length; return " لطفا بیش از"+n+"کاراکتر وارد نمایید "; },
        formatInputTooLong: function (input, max) { var n = input.length - max; return " لطفا" + n + " کاراکتر را حذف کنید."; },
        formatSelectionTooBig: function (limit) { return "شما فقط می‌توانید " + limit + " مورد را انتخاب کنید"; },
        formatLoadMore: function (pageNumber) { return "در حال بارگذاری موارد بیشتر ..."; },
        formatSearching: function () { return "در حال جستجو"; }
    });
})(jQuery);
