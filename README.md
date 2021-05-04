# SatNOGS Ground Station Client software.

This Yocto Project layer automates the reception of signals from satellites (cubesats, amateur radio satellites, weather satellites) for the satnogs.org network.

## Dependencies

### meta-amatuerradio
* URI: https://github.com/adrians/meta-amateurradio.git
* branch: master
* revision: HEAD

### meta-sdr
* URI: https://github.com/balister/meta-sdr.git
* branch: master
* revision: c08f9994f0d68dd91e6e1a198d8df0ed42c492f5

### meta-openembedded
* URI: https://git.openembedded.org/meta-openembedded
* branch: gatesgarth
* revision: HEAD

### Native docker

The satnogs-decoders package requires docker to build.  The meta-virtualization layer doesn't provide docker-ce-native due too many recursive dependencies.
This recipe depends on a HOSTTOOLS docker binary being available on the build host instead.
This also requires the build user to be in the "docker" group and may require a reboot after the account is added.

## Maintainer

Bryan Schneiders
[pschneiders@trisept.com](mailto:pschneiders@trisept.com)

## License
[![license](https://img.shields.io/badge/license-AGPL%203.0-6672D8.svg)](LICENSE)
