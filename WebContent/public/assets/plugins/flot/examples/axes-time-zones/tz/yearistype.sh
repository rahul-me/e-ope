#*******************************************************************************
# Gridscape Solutions, Inc. - CONFIDENTIAL & PROPRIETARY
# --------------------------
# [2015] - [2020] Gridscape Solutions, Inc.
# All Rights Reserved.
#
# NOTICE:  All information contained herein is, and remains
# the property of Gridscape Solutions, Inc.
# The intellectual and technical concepts contained
# herein are proprietary to Gridscape Solutions, Inc.
# and may be covered by U.S. and Foreign Patents,
# patents in process, and are protected by trade secret or copyright law.
# Dissemination of this information or reproduction of this material
# is strictly forbidden unless prior written permission is obtained
# from Gridscape Solutions.
#*******************************************************************************
#*******************************************************************************
#*******************************************************************************
#*******************************************************************************
# /*************************************************************************
#  * 
#  * Gridscape Solutions, Inc. - CONFIDENTIAL & PROPRIETARY
#  * __________________
#  * 
#  *  [2015] - [2020] Gridscape Solutions, Inc.
#  *  All Rights Reserved.
#  * 
#  * NOTICE:  All information contained herein is, and remains
#  * the property of Gridscape Solutions, Inc.
#  * The intellectual and technical concepts contained
#  * herein are proprietary to Gridscape Solutions, Inc.
#  * and may be covered by U.S. and Foreign Patents,
#  * patents in process, and are protected by trade secret or copyright law.
#  * Dissemination of this information or reproduction of this material
#  * is strictly forbidden unless prior written permission is obtained
#  * from Gridscape Solutions.
#  */
#*******************************************************************************
#! /bin/sh

: 'This file is in the public domain, so clarified as of'
: '2006-07-17 by Arthur David Olson.'

case $#-$1 in
	2-|2-0*|2-*[!0-9]*)
		echo "$0: wild year - $1" >&2
		exit 1 ;;
esac

case $#-$2 in
	2-even)
		case $1 in
			*[24680])			exit 0 ;;
			*)				exit 1 ;;
		esac ;;
	2-nonpres|2-nonuspres)
		case $1 in
			*[02468][048]|*[13579][26])	exit 1 ;;
			*)				exit 0 ;;
		esac ;;
	2-odd)
		case $1 in
			*[13579])			exit 0 ;;
			*)				exit 1 ;;
		esac ;;
	2-uspres)
		case $1 in
			*[02468][048]|*[13579][26])	exit 0 ;;
			*)				exit 1 ;;
		esac ;;
	2-*)
		echo "$0: wild type - $2" >&2 ;;
esac

echo "$0: usage is $0 year even|odd|uspres|nonpres|nonuspres" >&2
exit 1
