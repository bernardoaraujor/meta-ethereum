# Copyright (C) 2019 Bernardo Rodrigues <bernardoar@protonmail.com>

SUMMARY = "Parity Ethereum client"
DESCRIPTION = "Built for mission-critical use: Miners, service providers, and exchanges need fast synchronisation and maximum uptime. Parity Ethereum provides the core infrastructure essential for speedy and reliable services. Clean, modular codebase for easy customisation. Advanced CLI-based client. Minimal memory and storage footprint. Synchronise in hours, not days with Warp Sync. Modular for light integration into your service or product."
HOMEPAGE = "https://parity.io"
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM ="file://LICENSE;md5=7702f203b58979ebbc31bfaeb44f219c"

inherit cargo

# SRC_URI += "crate://crates.io/parity-ethereum/2.5.3"
SRC_URI = "gitsm://github.com/paritytech/parity-ethereum;tag=v${PV};nobranch=1"

S = "${WORKDIR}/git"
CARGO_SRC_DIR=""

SRC_URI += " \
	     crate://crates.io/aho-corasick/0.6.8 \
	     crate://crates.io/ansi_term/0.10.2 \
	     crate://crates.io/ansi_term/0.11.0 \
	     crate://crates.io/arrayref/0.3.5 \
	     crate://crates.io/arrayvec/0.4.7 \
	     crate://crates.io/ascii/0.7.1 \
	     crate://crates.io/assert_matches/1.3.0 \
	     crate://crates.io/atty/0.2.11 \
	     crate://crates.io/backtrace-sys/0.1.24 \
	     crate://crates.io/backtrace/0.3.9 \
	     crate://crates.io/base-x/0.2.3 \
	     crate://crates.io/base64/0.10.1 \
	     crate://crates.io/base64/0.9.3 \
	     crate://crates.io/bincode/0.8.0 \
	     crate://crates.io/bit-set/0.4.0 \
	     crate://crates.io/bit-vec/0.4.4 \
	     crate://crates.io/bitflags/0.7.0 \
	     crate://crates.io/bitflags/0.9.1 \
	     crate://crates.io/bitflags/1.0.4 \
	     crate://crates.io/block-buffer/0.3.3 \
	     crate://crates.io/byte-tools/0.2.0 \
	     crate://crates.io/byteorder/1.2.6 \
	     crate://crates.io/bytes/0.1.2 \
	     crate://crates.io/bytes/0.4.10 \
	     crate://crates.io/cast/0.2.2 \
	     crate://crates.io/cc/1.0.28 \
	     crate://crates.io/cesu8/1.1.0 \
	     crate://crates.io/cfg-if/0.1.5 \
	     crate://crates.io/chrono/0.4.6 \
	     crate://crates.io/cid/0.3.0 \
	     crate://crates.io/clap/2.32.0 \
	     crate://crates.io/cloudabi/0.0.3 \
	     crate://crates.io/cmake/0.1.35 \
	     crate://crates.io/combine/3.6.1 \
	     crate://crates.io/criterion-plot/0.2.5 \
	     crate://crates.io/criterion-stats/0.2.5 \
	     crate://crates.io/criterion/0.2.5 \
	     crate://crates.io/crossbeam-channel/0.2.6 \
	     crate://crates.io/crossbeam-deque/0.2.0 \
	     crate://crates.io/crossbeam-deque/0.5.2 \
	     crate://crates.io/crossbeam-deque/0.6.1 \
	     crate://crates.io/crossbeam-epoch/0.3.1 \
	     crate://crates.io/crossbeam-epoch/0.5.2 \
	     crate://crates.io/crossbeam-epoch/0.6.1 \
	     crate://crates.io/crossbeam-utils/0.2.2 \
	     crate://crates.io/crossbeam-utils/0.5.0 \
	     crate://crates.io/crossbeam-utils/0.6.2 \
	     crate://crates.io/crossbeam/0.4.1 \
	     crate://crates.io/crunchy/0.1.6 \
	     crate://crates.io/crunchy/0.2.1 \
	     crate://crates.io/csv-core/0.1.4 \
	     crate://crates.io/csv/1.0.2 \
	     crate://crates.io/ct-logs/0.5.1 \
	     crate://crates.io/derive_more/0.14.0 \
	     crate://crates.io/difference/1.0.0 \
	     crate://crates.io/digest/0.7.6 \
	     crate://crates.io/docopt/1.0.2 \
	     crate://crates.io/edit-distance/2.0.1 \
	     crate://crates.io/either/1.5.0 \
	     crate://crates.io/elastic-array/0.10.0 \
	     crate://crates.io/enum_primitive/0.1.1 \
	     crate://crates.io/env_logger/0.5.13 \
	     crate://crates.io/error-chain/0.12.0 \
	     crate://crates.io/ethabi-contract/6.0.0 \
	     crate://crates.io/ethabi-derive/6.0.2 \
	     crate://crates.io/ethabi/6.1.0 \
	     crate://crates.io/ethbloom/0.5.0 \
	     crate://crates.io/ethereum-types-serialize/0.2.2 \
	     crate://crates.io/ethereum-types/0.4.2 \
	     crate://crates.io/failsafe/0.3.0 \
	     crate://crates.io/failure/0.1.3 \
	     crate://crates.io/failure_derive/0.1.3 \
	     crate://crates.io/fake-simd/0.1.2 \
	     crate://crates.io/fdlimit/0.1.1 \
	     crate://crates.io/fixed-hash/0.2.2 \
	     crate://crates.io/fixedbitset/0.1.9 \
	     crate://crates.io/fnv/1.0.6 \
	     crate://crates.io/fs-swap/0.2.4 \
	     crate://crates.io/fs_extra/1.1.0 \
	     crate://crates.io/fuchsia-zircon-sys/0.3.3 \
	     crate://crates.io/fuchsia-zircon/0.3.3 \
	     crate://crates.io/futures-cpupool/0.1.8 \
	     crate://crates.io/futures/0.1.25 \
	     crate://crates.io/fxhash/0.2.1 \
	     crate://crates.io/gcc/0.3.55 \
	     crate://crates.io/generic-array/0.9.0 \
	     crate://crates.io/getopts/0.2.18 \
	     crate://crates.io/globset/0.4.2 \
	     crate://crates.io/h2/0.1.12 \
	     crate://crates.io/hamming/0.1.3 \
	     crate://crates.io/handlebars/0.32.4 \
	     crate://crates.io/hash-db/0.11.0 \
	     crate://crates.io/heck/0.3.0 \
	     crate://crates.io/hex/0.2.0 \
	     crate://crates.io/home/0.3.3 \
	     crate://crates.io/http/0.1.15 \
	     crate://crates.io/httparse/1.3.3 \
	     crate://crates.io/humantime/1.1.1 \
	     crate://crates.io/hyper-rustls/0.16.0 \
	     crate://crates.io/hyper/0.11.27 \
	     crate://crates.io/hyper/0.12.19 \
	     crate://crates.io/idna/0.1.5 \
	     crate://crates.io/if_chain/0.1.3 \
	     crate://crates.io/igd/0.7.0 \
	     crate://crates.io/indexmap/1.0.2 \
	     crate://crates.io/integer-encoding/1.0.5 \
	     crate://crates.io/interleaved-ordered/0.1.1 \
	     crate://crates.io/iovec/0.1.2 \
	     crate://crates.io/ipnetwork/0.12.8 \
	     crate://crates.io/itertools-num/0.1.2 \
	     crate://crates.io/itertools/0.5.10 \
	     crate://crates.io/itertools/0.7.8 \
	     crate://crates.io/itoa/0.4.3 \
	     crate://crates.io/jemalloc-sys/0.1.8 \
	     crate://crates.io/jemallocator/0.1.9 \
	     crate://crates.io/jni-sys/0.3.0 \
	     crate://crates.io/jni/0.11.0 \
	     crate://crates.io/jsonrpc-core/10.0.1 \
	     crate://crates.io/jsonrpc-derive/10.0.2 \
	     crate://crates.io/jsonrpc-http-server/10.0.1 \
	     crate://crates.io/jsonrpc-ipc-server/10.0.1 \
	     crate://crates.io/jsonrpc-pubsub/10.0.1 \
	     crate://crates.io/jsonrpc-server-utils/10.0.1 \
	     crate://crates.io/jsonrpc-tcp-server/10.0.1 \
	     crate://crates.io/jsonrpc-ws-server/10.0.1 \
	     crate://crates.io/keccak-hash/0.1.2 \
	     crate://crates.io/kernel32-sys/0.2.2 \
	     crate://crates.io/kvdb-memorydb/0.1.0 \
	     crate://crates.io/kvdb-rocksdb/0.1.4 \
	     crate://crates.io/kvdb/0.1.0 \
	     crate://crates.io/language-tags/0.2.2 \
	     crate://crates.io/lazy_static/1.3.0 \
	     crate://crates.io/lazycell/1.2.0 \
	     crate://crates.io/libc/0.2.48 \
	     crate://crates.io/libloading/0.5.0 \
	     crate://crates.io/linked-hash-map/0.5.1 \
	     crate://crates.io/local-encoding/0.2.0 \
	     crate://crates.io/lock_api/0.1.4 \
	     crate://crates.io/log/0.3.9 \
	     crate://crates.io/log/0.4.6 \
	     crate://crates.io/lru-cache/0.1.2 \
	     crate://crates.io/lunarity-lexer/0.1.0 \
	     crate://crates.io/matches/0.1.8 \
	     crate://crates.io/memchr/2.1.0 \
	     crate://crates.io/memmap/0.6.2 \
	     crate://crates.io/memoffset/0.2.1 \
	     crate://crates.io/memory-db/0.11.0 \
	     crate://crates.io/memory_units/0.3.0 \
	     crate://crates.io/mime/0.3.12 \
	     crate://crates.io/mime_guess/2.0.0-alpha.6 \
	     crate://crates.io/mio-extras/2.0.5 \
	     crate://crates.io/mio-named-pipes/0.1.6 \
	     crate://crates.io/mio-uds/0.6.7 \
	     crate://crates.io/mio/0.6.16 \
	     crate://crates.io/miow/0.2.1 \
	     crate://crates.io/miow/0.3.3 \
	     crate://crates.io/multibase/0.6.0 \
	     crate://crates.io/multihash/0.8.0 \
	     crate://crates.io/nan-preserving-float/0.1.0 \
	     crate://crates.io/net2/0.2.33 \
	     crate://crates.io/nodrop/0.1.12 \
	     crate://crates.io/num-bigint/0.1.44 \
	     crate://crates.io/num-bigint/0.2.2 \
	     crate://crates.io/num-integer/0.1.39 \
	     crate://crates.io/num-iter/0.1.37 \
	     crate://crates.io/num-traits/0.1.43 \
	     crate://crates.io/num-traits/0.2.6 \
	     crate://crates.io/num/0.1.42 \
	     crate://crates.io/num_cpus/1.10.0 \
	     crate://crates.io/number_prefix/0.2.8 \
	     crate://crates.io/ole32-sys/0.2.0 \
	     crate://crates.io/order-stat/0.1.3 \
	     crate://crates.io/ordered-float/0.5.2 \
	     crate://crates.io/ordermap/0.3.5 \
	     crate://crates.io/owning_ref/0.3.3 \
	     crate://crates.io/parity-bytes/0.1.0 \
	     crate://crates.io/parity-crypto/0.3.0 \
	     crate://crates.io/parity-daemonize/0.3.0 \
	     crate://crates.io/parity-path/0.1.1 \
	     crate://crates.io/parity-rocksdb-sys/0.5.5 \
	     crate://crates.io/parity-rocksdb/0.5.0 \
	     crate://crates.io/parity-snappy-sys/0.1.2 \
	     crate://crates.io/parity-snappy/0.1.0 \
	     crate://crates.io/parity-tokio-ipc/0.1.0 \
	     crate://crates.io/parity-wasm/0.31.3 \
	     crate://crates.io/parity-wordlist/1.2.1 \
	     crate://crates.io/parity-ws/0.8.0 \
	     crate://crates.io/parking_lot/0.6.4 \
	     crate://crates.io/parking_lot/0.7.1 \
	     crate://crates.io/parking_lot_core/0.3.1 \
	     crate://crates.io/parking_lot_core/0.4.0 \
	     crate://crates.io/percent-encoding/1.0.1 \
	     crate://crates.io/pest/1.0.6 \
	     crate://crates.io/pest_derive/1.0.8 \
	     crate://crates.io/petgraph/0.4.13 \
	     crate://crates.io/phf/0.7.23 \
	     crate://crates.io/phf_codegen/0.7.23 \
	     crate://crates.io/phf_generator/0.7.23 \
	     crate://crates.io/phf_shared/0.7.23 \
	     crate://crates.io/plain_hasher/0.2.0 \
	     crate://crates.io/pretty_assertions/0.1.2 \
	     crate://crates.io/primal-bit/0.2.4 \
	     crate://crates.io/primal-check/0.2.3 \
	     crate://crates.io/primal-estimate/0.2.1 \
	     crate://crates.io/primal-sieve/0.2.9 \
	     crate://crates.io/primal/0.2.3 \
	     crate://crates.io/proc-macro2/0.4.20 \
	     crate://crates.io/protobuf/1.7.5 \
	     crate://crates.io/pulldown-cmark/0.0.3 \
	     crate://crates.io/pwasm-utils/0.6.1 \
	     crate://crates.io/quick-error/1.2.2 \
	     crate://crates.io/quote/0.3.15 \
	     crate://crates.io/quote/0.6.8 \
	     crate://crates.io/rand/0.3.22 \
	     crate://crates.io/rand/0.4.3 \
	     crate://crates.io/rand/0.5.5 \
	     crate://crates.io/rand/0.6.1 \
	     crate://crates.io/rand_chacha/0.1.0 \
	     crate://crates.io/rand_core/0.2.2 \
	     crate://crates.io/rand_core/0.3.0 \
	     crate://crates.io/rand_hc/0.1.0 \
	     crate://crates.io/rand_isaac/0.1.1 \
	     crate://crates.io/rand_pcg/0.1.1 \
	     crate://crates.io/rand_xorshift/0.1.0 \
	     crate://crates.io/rayon-core/1.4.1 \
	     crate://crates.io/rayon/1.0.2 \
	     crate://crates.io/redox_syscall/0.1.40 \
	     crate://crates.io/redox_termios/0.1.1 \
	     crate://crates.io/regex-syntax/0.5.6 \
	     crate://crates.io/regex-syntax/0.6.2 \
	     crate://crates.io/regex/0.2.11 \
	     crate://crates.io/regex/1.1.2 \
	     crate://crates.io/relay/0.1.1 \
	     crate://crates.io/remove_dir_all/0.5.1 \
	     crate://crates.io/ring/0.14.3 \
	     crate://crates.io/rlp/0.2.4 \
	     crate://crates.io/rlp/0.3.0 \
	     crate://crates.io/rpassword/1.0.2 \
	     crate://crates.io/rprompt/1.0.3 \
	     crate://crates.io/rust-crypto/0.2.36 \
	     crate://crates.io/rustc-demangle/0.1.9 \
	     crate://crates.io/rustc-hex/1.0.0 \
	     crate://crates.io/rustc-hex/2.0.1 \
	     crate://crates.io/rustc-serialize/0.3.24 \
	     crate://crates.io/rustc_version/0.2.3 \
	     crate://crates.io/rustls/0.15.1 \
	     crate://crates.io/ryu/0.2.6 \
	     crate://crates.io/safemem/0.3.0 \
	     crate://crates.io/same-file/1.0.3 \
	     crate://crates.io/scoped-tls/0.1.2 \
	     crate://crates.io/scopeguard/0.3.3 \
	     crate://crates.io/sct/0.5.0 \
	     crate://crates.io/semver-parser/0.7.0 \
	     crate://crates.io/semver/0.9.0 \
	     crate://crates.io/serde/1.0.89 \
	     crate://crates.io/serde_derive/1.0.89 \
	     crate://crates.io/serde_json/1.0.39 \
	     crate://crates.io/sha1/0.5.0 \
	     crate://crates.io/sha1/0.6.0 \
	     crate://crates.io/sha2/0.7.1 \
	     crate://crates.io/shell32-sys/0.1.2 \
	     crate://crates.io/simplelog/0.5.3 \
	     crate://crates.io/siphasher/0.1.3 \
	     crate://crates.io/siphasher/0.2.3 \
	     crate://crates.io/skeptic/0.4.0 \
	     crate://crates.io/slab/0.2.0 \
	     crate://crates.io/slab/0.3.0 \
	     crate://crates.io/slab/0.4.1 \
	     crate://crates.io/smallvec/0.6.5 \
	     crate://crates.io/socket2/0.3.8 \
	     crate://crates.io/stable_deref_trait/1.1.1 \
	     crate://crates.io/string/0.1.1 \
	     crate://crates.io/strsim/0.7.0 \
	     crate://crates.io/syn/0.11.11 \
	     crate://crates.io/syn/0.15.26 \
	     crate://crates.io/synom/0.11.3 \
	     crate://crates.io/synstructure/0.10.1 \
	     crate://crates.io/target_info/0.1.0 \
	     crate://crates.io/tempdir/0.3.7 \
	     crate://crates.io/term/0.5.1 \
	     crate://crates.io/term_size/0.3.1 \
	     crate://crates.io/termcolor/1.0.4 \
	     crate://crates.io/termion/1.5.1 \
	     crate://crates.io/textwrap/0.10.0 \
	     crate://crates.io/textwrap/0.9.0 \
	     crate://crates.io/thread-id/3.3.0 \
	     crate://crates.io/thread-scoped/1.0.2 \
	     crate://crates.io/thread_local/0.3.6 \
	     crate://crates.io/threadpool/1.7.1 \
	     crate://crates.io/time/0.1.40 \
	     crate://crates.io/timer/0.2.0 \
	     crate://crates.io/tiny-keccak/1.4.2 \
	     crate://crates.io/tokio-codec/0.1.1 \
	     crate://crates.io/tokio-core/0.1.17 \
	     crate://crates.io/tokio-current-thread/0.1.3 \
	     crate://crates.io/tokio-executor/0.1.5 \
	     crate://crates.io/tokio-fs/0.1.3 \
	     crate://crates.io/tokio-io/0.1.9 \
	     crate://crates.io/tokio-named-pipes/0.1.0 \
	     crate://crates.io/tokio-reactor/0.1.6 \
	     crate://crates.io/tokio-retry/0.1.1 \
	     crate://crates.io/tokio-rustls/0.9.0 \
	     crate://crates.io/tokio-service/0.1.0 \
	     crate://crates.io/tokio-tcp/0.1.2 \
	     crate://crates.io/tokio-threadpool/0.1.7 \
	     crate://crates.io/tokio-timer/0.1.2 \
	     crate://crates.io/tokio-timer/0.2.7 \
	     crate://crates.io/tokio-udp/0.1.2 \
	     crate://crates.io/tokio-uds/0.2.2 \
	     crate://crates.io/tokio/0.1.11 \
	     crate://crates.io/toml/0.4.10 \
	     crate://crates.io/toolshed/0.4.0 \
	     crate://crates.io/trace-time/0.1.1 \
	     crate://crates.io/transaction-pool/2.0.0 \
	     crate://crates.io/transient-hashmap/0.4.1 \
	     crate://crates.io/trie-db/0.11.0 \
	     crate://crates.io/trie-standardmap/0.1.1 \
	     crate://crates.io/triehash/0.4.0 \
	     crate://crates.io/try-lock/0.1.0 \
	     crate://crates.io/try-lock/0.2.2 \
	     crate://crates.io/typenum/1.10.0 \
	     crate://crates.io/ucd-util/0.1.1 \
	     crate://crates.io/uint/0.4.1 \
	     crate://crates.io/unicase/1.4.2 \
	     crate://crates.io/unicase/2.2.0 \
	     crate://crates.io/unicode-bidi/0.3.4 \
	     crate://crates.io/unicode-normalization/0.1.7 \
	     crate://crates.io/unicode-segmentation/1.2.1 \
	     crate://crates.io/unicode-width/0.1.5 \
	     crate://crates.io/unicode-xid/0.0.4 \
	     crate://crates.io/unicode-xid/0.1.0 \
	     crate://crates.io/unreachable/1.0.0 \
	     crate://crates.io/untrusted/0.6.2 \
	     crate://crates.io/url/1.7.1 \
	     crate://crates.io/utf8-ranges/1.0.1 \
	     crate://crates.io/validator/0.8.0 \
	     crate://crates.io/validator_derive/0.8.0 \
	     crate://crates.io/vec_map/0.8.1 \
	     crate://crates.io/vergen/0.1.1 \
	     crate://crates.io/version_check/0.1.5 \
	     crate://crates.io/void/1.0.2 \
	     crate://crates.io/walkdir/2.2.5 \
	     crate://crates.io/want/0.0.4 \
	     crate://crates.io/want/0.0.6 \
	     crate://crates.io/wasmi/0.3.0 \
	     crate://crates.io/webpki-roots/0.16.0 \
	     crate://crates.io/webpki/0.19.1 \
	     crate://crates.io/winapi-build/0.1.1 \
	     crate://crates.io/winapi-i686-pc-windows-gnu/0.4.0 \
	     crate://crates.io/winapi-util/0.1.1 \
	     crate://crates.io/winapi-x86_64-pc-windows-gnu/0.4.0 \
	     crate://crates.io/winapi/0.2.8 \
	     crate://crates.io/winapi/0.3.6 \
	     crate://crates.io/wincolor/1.0.1 \
	     crate://crates.io/ws2_32-sys/0.2.1 \
	     crate://crates.io/xdg/2.1.0 \
	     crate://crates.io/xml-rs/0.7.0 \
	     crate://crates.io/xmltree/0.7.0 \
"

SRC_URI_heapsize += "git://github.com/cheme/heapsize.git;protocol=https;name=heapsize;destsuffix=heapsize"
SRCREV_FORMAT .= "_heapsize"
SRCREV_heapsize = "ec-macfix"
EXTRA_OECARGO_PATHS += "${WORKDIR}/heapsize"

SRC_URI_eth-secp256k1 += "git://github.com/paritytech/rust-secp256k1;protocol=https;name=eth-secp256k1;destsuffix=eth-secp256k1"
SRCREV_FORMAT .= "_eth-secp256k1"
SRCREV_eth-secp256k1 = "${AUTOREV}"
EXTRA_OECARGO_PATHS += "${WORKDIR}/eth-secp256k1"

SRC_URI_app_dirs += "git://github.com/paritytech/app-dirs-rs;protocol=https;name=app_dirs;destsuffix=app_dirs"
SRCREV_FORMAT .= "_app_dirs"
SRCREV_app_dirs = "${AUTOREV}"
EXTRA_OECARGO_PATHS += "${WORKDIR}/app_dirs"

SRC_URI_libusb += "git://github.com/paritytech/libusb-rs;protocol=https;name=libusb;destsuffix=libusb"
SRCREV_FORMAT .= "_libusb"
SRCREV_libusb = "${AUTOREV}"
EXTRA_OECARGO_PATHS += "${WORKDIR}/libusb"

SRC_URI_hidapi += "git://github.com/paritytech/hidapi-rs;protocol=https;name=hidapi;destsuffix=hidapi"
SRCREV_FORMAT .= "_hidapi"
SRCREV_hidapi = "${AUTOREV}"
EXTRA_OECARGO_PATHS += "${WORKDIR}/hidapi"

SRC_URI-ctrlc += "git://github.com/paritytech/rust-ctrlc.git;protocol=https;name=ctrlc;destsuffix=ctrlc"
SRCREV_FORMAT .= "_ctrlc"
SRCREV_ctrlc = "${AUTOREV}"
EXTRA_OECARGO_PATHS += "${WORKDIR}/ctrlc"

SRC_URI_trezor-sys += "git://github.com/paritytech/trezor-sys;protocol=https;name=trezor-sys;destsuffix=trezor-sys"
SRCREV_FORMAT .= "_trezor-sys"
SRCREV_trezor-sys = "${AUTOREV}"
EXTRA_OECARGO_PATHS += "${WORKDIR}/trezor-sys"

SRC_URI_libusb-sys += "git://github.com/paritytech/libusb-sys;protocol=https;name=libusb-sys;destsuffix=libusb-sys"
SRCREV_FORMAT .= "_libusb-sys"
SRCREV_libusb-sys = "${AUTOREV}"
EXTRA_OECARGO_PATHS += "${WORKDIR}/libusb-sys"

SRC_URI_bn += "git://github.com/paritytech/bn;protocol=https;name=bn;destsuffix=bn"
SRCREV_FORMAT .= "_bn"
SRCREV_bn = "${AUTOREV}"
EXTRA_OECARGO_PATHS += "${WORKDIR}/bn"
