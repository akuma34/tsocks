SUMMARY = "tsocks used for proxy"
DESCRIPTION = "used to bypass Intel network to conenct the clanton to the outside internet"
LICENSE = "GPLv2+"

 
RDEPENDS = "uclibc"

#SRCREV_default_pn-tsocks = "8a6f7d7304e9018e4965fcb8d1d1591c6f1a5f7a"
SRCREV_default_pn-tsocks = "master"
SRC_URI = "git://github.com/akuma34/tsocks"

#calcualte from "md5sum"
SRC_URI[md5sum] = "51caefd77e5d440d0bbd6443db4fc0f8"




LOCALSRC = "file://${WORKDIR}/git/tsocks-1.8beta5.tar.gz"

S = "${WORKDIR}/tsocks-1.8"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=e8c1458438ead3c34974bc0be3a03ed6"

python do_unpack () {
    bb.build.exec_func('base_do_unpack', d)
    src_uri = d.getVar('SRC_URI')
    d.setVar('SRC_URI', '${LOCALSRC}')
    bb.build.exec_func('base_do_unpack', d)
    d.setVar('SRC_URI', src_uri)
}




do_configure () {
echo "workdir ${WORKDIR}"
#  ./configure --prefix=${prefix} --without-snapshot
  ./configure --prefix=${prefix}
}
do_compile () {
  make
}
do_install () {
  oe_runmake install DESTDIR=${D}
}
