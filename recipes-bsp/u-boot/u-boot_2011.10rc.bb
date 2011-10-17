require u-boot.inc

# No patches for other machines yet
COMPATIBLE_MACHINE = "(ti33x)"
DEFAULT_PREFERENCE_ti33x = "99"
PV = "2011.09+git"
PR = "r9"

# SPL build
UBOOT_BINARY = "u-boot.img"
UBOOT_IMAGE = "u-boot-${MACHINE}-${PV}-${PR}.img"
UBOOT_SYMLINK = "u-boot-${MACHINE}.img"

SRC_URI = "git://github.com/trini/u-boot.git;protocol=git;branch=int_am335xpsp_04.06.00.01-v2011.09-for-sdk-05.03.00.00 \
           file://2011.09git/0001-am335x_evm-boot-kernel-from-ext2-3-filesystem.patch \
           file://2011.09git/0002-am335x_evm-set-bootdelay-to-0.patch \
           file://2011.09git/0003-am335x-evm-make-rootfs-RO-on-boot.patch \
          "

SRCREV = "3fb65523c5994718b56a3b4b18ddf1ef3ffc02dc"

LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

S = "${WORKDIR}/git"

do_deploy_append () {
    install ${S}/MLO ${DEPLOY_DIR_IMAGE}/MLO
}