package www.onbeatapps.com.ui.homeFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import www.onbeatapps.com.R
import www.onbeatapps.com.databinding.FragmentTrListBinding
import www.onbeatapps.com.databinding.HomeFragmentBinding
import www.onbeatapps.com.ui.base.BaseFragment
import www.onbeatapps.com.ui.dashBoardActivity.DashBoardActivity.Companion.clickEventSlide
import www.onbeatapps.com.ui.dashBoardActivity.DashBoardActivity.Companion.exit
import www.onbeatapps.com.utils.NotificationEvent
import java.util.*



@AndroidEntryPoint
class TrListFragment : BaseFragment<HomeViewModel>() {
    private var _binding: FragmentTrListBinding? = null
    private val binding get() = _binding!!
    private val homeViewModel: HomeViewModel by viewModels()
    private var homeAdapter: HomeAdapter? = null
    var writBandBalance = ""

    override fun setup() {

        setUpRV()
        setUpClick()
        setUpObserver()
        homeViewModel.getTransationList()
    }

    private fun setUpRV() {
        homeAdapter = HomeAdapter(mContext,homeViewModel)
        binding.recyTrans.apply {
            setHasFixedSize(true)
            adapter = homeAdapter
        }
    }

    private fun setUpObserver() {
        binding.apply {
            homeViewModel.trList.observe(viewLifecycleOwner) {
                if (it.isNotEmpty()) {
                    homeAdapter?.setListContent(it)
                    txtTotalSpend.text = "${homeViewModel.currency} ${homeViewModel.total_spent}"
                }else {
                    txtTotalSpend.text = "${homeViewModel.currency} 00.00"
                    noDatHide()
                }
            }
        }
    }

    fun noDatHide() {
        binding.apply {
            txtNodat.visibility = View.VISIBLE
//            containTr.visibility = View.GONE
        }
    }
    private fun setUpClick() {
        binding.apply {
            btBack.setOnClickListener {
                findNavController().popBackStack()
            }
            swipeRefresh.setOnRefreshListener {
                homeViewModel.getTransationList()
                swipeRefresh.isRefreshing = false
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        activity?.window?.statusBarColor = resources.getColor(R.color.white)
        activity?.window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        _binding = FragmentTrListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        EventBus.getDefault().register(this)
    }

    override fun onPause() {
        super.onPause()
        EventBus.getDefault().unregister(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun getViewModel() = homeViewModel

        @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: NotificationEvent) {
        if (event == NotificationEvent.Reload) {
            homeViewModel.getUserDt()

        }
    }

}