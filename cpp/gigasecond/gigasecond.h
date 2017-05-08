#ifndef _GIGASECOND_H
#define _GIGASECOND_H

#include <boost/date_time/posix_time/posix_time.hpp>

namespace gigasecond {
    namespace pt = boost::posix_time;
    pt::ptime advance(pt::ptime const base);
}

#endif // _GIGASECOND_H
