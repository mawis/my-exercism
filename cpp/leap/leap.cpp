#include "leap.h"

namespace leap {
    bool is_leap_year(int const year) {
	auto divisible_by =
	    [=] (int const divisor) { return year % divisor == 0; };

	return divisible_by(400) || divisible_by(4) && !divisible_by(100);
    }
}
