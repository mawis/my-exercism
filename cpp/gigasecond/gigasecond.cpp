#include "gigasecond.h"

namespace gigasecond {
    using namespace boost::posix_time;

    const auto GIGASECOND = seconds(1'000'000'000);

    ptime advance(ptime const base) {
	return base + GIGASECOND;
    }
}
